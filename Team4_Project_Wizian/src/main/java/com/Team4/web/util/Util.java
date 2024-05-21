package com.Team4.web.util;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class Util {
    
    @Value("${aws.bucketName}")
    private String bucketName;
    @Value("${aws.access-key}")
    private String accessKey;
    @Value("${aws.secret-key}")
    private String secretKey;
    public HttpServletRequest req() {
        
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        return request;
    }
    
    public HttpSession getSession() {
        HttpSession session = req().getSession();
        return session;
    }
    
    public String fileUpload(MultipartFile upFile) {
        //경로저장
        String root = req().getSession().getServletContext().getRealPath("/");
        
        String upfilePath = root + "resources\\upfile\\";
        System.out.println("경로는" + upfilePath);
        //UUID 뽑기
        UUID uuid = UUID.randomUUID();
        //UUID를 포함한 파일명
        String newFileName = uuid.toString();
        
        File file = new File(upfilePath, newFileName); // 앞은 경로, 뒤는 파일이름
        System.out.println("경로는" + upfilePath + "파일이름" + newFileName);
        if (file.exists() == false) {
            file.mkdirs();//경로가 없다면 다 만들어주기.
        }
        try {
            upFile.transferTo(file); // 멀티파츠의 트랜스퍼 호출 = 파일전송
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    public String fileUploadAws(MultipartFile upFile) {
        // 파일명 생성
        String newFileName2 = generateFileName(upFile.getOriginalFilename());

        // 업로드된 파일이 임시 디렉토리에 저장되도록 수정
        try {
            // 임시 디렉토리에 파일을 저장
            File tempFile = File.createTempFile("temp", null);
            upFile.transferTo(tempFile);

            // S3에 업로드
            uploadToS3(tempFile, newFileName2, upFile.getContentType());

            // 업로드 후 임시 파일 삭제
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
            // 파일 업로드 중 예외 발생 시 빈 파일명 반환
            newFileName2 = "";
        }

        return newFileName2;
    }

    private String generateFileName(String originalFileName) {
        String[] fileNameParts = originalFileName.split("\\.");
        String extension = fileNameParts[fileNameParts.length - 1];
        return UUID.randomUUID().toString() + "." + extension;
    }

    private void uploadToS3(File file, String newFileName2, String contentType) throws IOException {
        // 클라이언트 구성 설정
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setProtocol(Protocol.HTTP); // 프로토콜 설정 (HTTP 또는 HTTPS)

        // AWS S3 클라이언트 생성
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion("ap-northeast-2") // AWS 리전 설정
                .withClientConfiguration(clientConfiguration)
                .build();

        // 파일 업로드 요청 생성
        PutObjectRequest request = new PutObjectRequest(bucketName, newFileName2, file);

        // Content-Type 설정
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(contentType);
        request.setMetadata(metadata);

        // S3에 파일 업로드
        s3Client.putObject(request);
    }

    public String encryptSHA256(String str){
    	String sha = ""; 
    	try{
    		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
    		sh.update(str.getBytes()); 
    		byte byteData[] = sh.digest();
    		StringBuffer sb = new StringBuffer(); 
    		for(int i = 0 ; i < byteData.length ; i++){
    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
    		}
    		sha = sb.toString();
    	}catch(NoSuchAlgorithmException e){
    		//e.printStackTrace(); 
    		System.out.println("Encrypt Error - NoSuchAlgorithmException");
    		sha = null; 
    	}
    	return sha;
    }

}