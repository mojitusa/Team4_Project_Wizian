package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.web.model.FileModel;
import com.Team4.web.service.FileUploadService;
import com.Team4.web.util.Util;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService fileService;
	
	@Autowired
	private Util util;
	
	@GetMapping("/file")
	public String file() {
		return "file";
	}
	
	@PostMapping("/file")
	public String file(@RequestParam("file1") MultipartFile upFile, HttpServletRequest request) {
		return "redirect:/file";
	}
	
	@PostMapping("/fileInsert")
	public String fileInsert(@RequestParam("file1") MultipartFile upFile, FileModel dto, HttpServletRequest request) {
	    if (request.getSession().getAttribute("username") != null) {
	        // 파일의 MIME 타입 확인
	        String contentType = upFile.getContentType();
	        if (contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/gif"))) {
	            // 파일 업로드 -> util
	            String newFileName = util.fileUpload(upFile);
	            String originalFilename = upFile.getOriginalFilename();
	            int lastIndex = originalFilename.lastIndexOf(".");
	            String extension = originalFilename.substring(lastIndex + 1);
	            dto.setUuid_file_Nm(newFileName); // UUID+
	            dto.setFile_sz(upFile.getSize());
	            dto.setActl_file_nm(originalFilename);
	            dto.setFile_extn_nm(extension);
	            System.out.println(newFileName);
	            System.out.println(upFile.getSize());
	            System.out.println(upFile.getOriginalFilename());
	            System.out.println(extension);
	            int result = fileService.FileInsert(dto);
	            System.out.println(result);
	            
	            util.fileUploadAws(upFile);
	            // 업로드를 요청한 이전 페이지의 URL 가져오기
	            String referer = request.getHeader("referer");
	            if (referer != null) {
	                return "redirect:" + referer;
	            } else {
	                return "redirect:/index";
	            }
	        } else {
	            // 이미지 파일이 아닌 경우 업로드 불가
	            return "redirect:/error";
	        }
	    } else {
	        return "redirect:/error";
	    }
	}


}
