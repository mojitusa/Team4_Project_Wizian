package com.Team4.web.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.web.service.GroupService;
import com.Team4.web.util.Util;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private Util util;

    @GetMapping("/group")
    public String showGroupPage(@RequestParam(value = "searchText", required = false, defaultValue = "") String searchWord,
        @RequestParam(value = "category", required = false) String category, Model model, HttpSession session) {

        if ((session.getAttribute("userNo")) != null) {
            String userNumber = (String) session.getAttribute("userNo");
            String userCode = userNumber.substring(0, 2);
            model.addAttribute("userCode", userCode);
        }

        List < Map < String, Object >> gclist = null;
        if ((searchWord != null && !searchWord.isEmpty()) || (category != null && !category.isEmpty())) {
            gclist = groupService.getgcListWithSearch(searchWord, category);
        } else {
            gclist = groupService.gclist();
        }
        model.addAttribute("gclist", gclist);

        return "content/group";
    }

    @GetMapping("/groupDetail")
    public String showGroupDetailPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd,
        Model model) {

        List < Map < String, Object >> proDetail = groupService.proDetail(procd);
        model.addAttribute("proDetail", proDetail);

        return "content/groupDetail";
    }

    @GetMapping("/groupApplyPage")
    public String showGroupapplyPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd, Model model, HttpSession session) {

        String studNumber = (String) session.getAttribute("userNo");
        String studName = (String) session.getAttribute("username");

        if (studNumber != null && studName != null) {
            List < Map < String, Object >> proDetail = groupService.proDetail(procd);
            model.addAttribute("proDetail", proDetail);

            return "content/groupApplyPage";
        } else {
            return "login";
        }
    }

    //그룹 상담 신청 메소드
    @PostMapping("/groupApplyPage")
    @ResponseBody
    public String groupapplyProgram(@RequestParam(name = "proCd", required = false, defaultValue = "") String proCode, HttpSession session) {

        String studNumber = (String) session.getAttribute("userNo");
        String studName = (String) session.getAttribute("username");

        if (studNumber != null && studName != null) {

            // 중복 검사 체크
            if (groupService.checkDuplicate(studNumber, proCode)) {
                System.out.println("중복검사가 정상적으로 작동되었습니다.");
                return "already_applied";
            }

            // 프로그램 기한 확인
            Map < String, Object > programDates = groupService.getProgramDates(proCode);
            if (programDates != null) {
                Date schdlBeginDate = (Date) programDates.get("SCHDL_BGNG_YMD");
                Date schdlEndDate = (Date) programDates.get("SCHDL_END_YMD");

                Timestamp schdlBegin = new Timestamp(schdlBeginDate.getTime());
                Timestamp schdlEnd = new Timestamp(schdlEndDate.getTime());
                Timestamp now = new Timestamp(System.currentTimeMillis());

                if (now.before(schdlBegin) || now.after(schdlEnd)) {
                    return "dateOver";
                }
            }
            // 프로그램 신청 TB에 저장
            int result = groupService.insertApply(studNumber, proCode);
            System.out.println("결과 확인 : " + result);

            return "success";
        } else {
            return "noLogin";
        }
    }

    @PostMapping("/groupapplyDelete")
    @ResponseBody
    public String groupapplyDelete(@RequestParam(name = "proCd", required = false, defaultValue = "") String proCode, HttpSession session) {

        String studNumber = (String) session.getAttribute("userNo");
        String studName = (String) session.getAttribute("username");

        if (studNumber != null && studName != null) {

            Map < String, Object > programCancelDate = groupService.getProgramCancelDate(proCode);
            if (programCancelDate != null) {
                Date gcDT = (Date) programCancelDate.get("GC_DT");
                Timestamp gcDt = new Timestamp(gcDT.getTime());
                Timestamp now = new Timestamp(System.currentTimeMillis());

                if (gcDt != null && now.after(gcDt)) {
                    return "dateOver";
                }
            }
            // 중복 검사 체크
            if (!groupService.checkDuplicate(studNumber, proCode)) {
                System.out.println("유효성 검사가 정상적으로 작동하였습니다.");
                return "no_exist";
            } else {
                // 프로그램 삭제 TB에 저장
                int result = groupService.deleteApply(studNumber, proCode);
                System.out.println("결과 확인 : " + result);

                // 성공 응답 반환
                return "success";
            }
        } else {
            return "noLogin";
        }
    }

    @PostMapping("/groupWritePath")
    @ResponseBody
    public String groupWritePost(HttpSession session) {
        String userNumber = (String) session.getAttribute("userNo");
        if (userNumber == null || userNumber.length() < 2) {
            return "login";
        }

        String userNumberPrefix = userNumber.substring(0, 2);

        if (!userNumberPrefix.equals("10") && !userNumberPrefix.equals("13")) {
            return "wrongAccess";
        }
        return "success";
    }

    @GetMapping("/groupWrite")
    public String groupWrite(HttpSession session) {
        String userCode = (String) session.getAttribute("SE_CD");
        if (userCode.equals("13")) {
            return "content/groupWrite";
        } else {
            return "/login";
        }
    }


    @PostMapping("/groupWrite")
    public void groupWrite(
        @RequestParam(name = "PRGRM_NM", required = false, defaultValue = "") String PRGRM_NM,
        @RequestParam(name = "SCHDL_BGNG_YMD", required = false, defaultValue = "") String SCHDL_BGNG_YMD,
        @RequestParam(name = "SCHDL_END_YMD", required = false, defaultValue = "") String SCHDL_END_YMD,
        @RequestParam(name = "GC_DT", required = false, defaultValue = "") String GC_DATE,
        @RequestParam(name = "NOPE", required = false, defaultValue = "") int NOPE,
        @RequestParam(name = "PRGRM_TYPE", required = false, defaultValue = "") String PRGRM_TYPE,
        @RequestParam(name = "GC_OG_NM", required = false, defaultValue = "") String GC_OG_NM,
        @RequestParam(name = "counselingContent", required = false, defaultValue = "") String counselingContent,
        @RequestParam(name = "posterContent", required = false, defaultValue = "") String posterContent,
        @RequestParam(name = "file1", required = false) MultipartFile file1, // 파일 파라미터 추가
        HttpServletResponse response, HttpSession session) {

        String userNumber = (String) session.getAttribute("userNo");
        String GC_DT = convertDateFormat(GC_DATE);

        // 파일 업로드 처리
        String fileUrl = null;
        if (file1 != null && !file1.isEmpty()) {
            fileUrl = util.fileUploadAws(file1);
        }

        // 원하는 로직 수행
        int result = groupService.insertRegister(PRGRM_NM, SCHDL_BGNG_YMD, SCHDL_END_YMD, GC_DT, NOPE, PRGRM_TYPE, GC_OG_NM, counselingContent, posterContent, userNumber, fileUrl);

        if (result == 1) {
            try {
                response.getWriter().write("success"); // 성공을 나타내는 문자열을 반환
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().write("false"); // 실패를 나타내는 문자열을 반환
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static String convertDateFormat(String inputDate) {
        // am 또는 pm 제거
        String cleanDate = inputDate.replaceAll("(am|pm)", "").trim();

        // 띄어쓰기를 통해 날짜와 시간 분리
        String[] parts = cleanDate.split(" ");
        String datePart = parts[0]; // 날짜 부분
        String timePart = parts[1]; // 시간 부분

        // 24시 형식으로 변환
        String[] timeParts = timePart.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if (timePart.toLowerCase().endsWith("pm")) {
            hour += 12; // 오후일 경우 12시간 추가
        }
        String convertedTimePart = String.format("%02d:%s", hour, timeParts[1]);

        return datePart + " " + convertedTimePart + ":00";
    }

}