package com.Team4.web.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mapper.GroupMapper;

@Service
public class GroupService {
	@Autowired
	public GroupMapper groupMapper;

	public List<Map<String, Object>> gclist() {
		return groupMapper.getgcList();
	}
	
	public List<Map<String, Object>> getgcListWithSearch(String searchWord, String category) {
		Map<String, Object> searchInfo = new HashMap<>();
		searchInfo.put("searchWord", searchWord);
		searchInfo.put("category", category);
		searchInfo.put("nowDate", LocalDateTime.now());
		searchInfo.put("sevenDaysLater", LocalDateTime.now().plusDays(7));
		searchInfo.put("dayOfMonth", LocalDateTime.now().getDayOfMonth());
		
		return groupMapper.getgcListWithSearch(searchInfo);
	}

	public List<Map<String, Object>> proDetail(int procd) {
		return groupMapper.getproDetail(procd);
	}

	public int insertApply(String studNumber, String proCode) {
	    Map<String, Object> applyInfo = new HashMap<>();
	    applyInfo.put("studNumber", studNumber);
	    applyInfo.put("proCode", proCode);
	    return groupMapper.insertApply(applyInfo);
	}

	public boolean checkDuplicate(String studNumber, String proCode) {
	    Map<String, Object> applyInfo = new HashMap<>();
	    applyInfo.put("studNumber", studNumber);
	    applyInfo.put("proCode", proCode);
        int count = groupMapper.checkDuplicate(applyInfo);
        return count > 0;
	}
	
    public Map<String, Object> getProgramDates(String proCode) {
        return groupMapper.getProgramDates(proCode);
    }	
	
	public int deleteApply(String studNumber, String proCode) {
	    Map<String, Object> applyInfo = new HashMap<>();
	    applyInfo.put("studNumber", studNumber);
	    applyInfo.put("proCode", proCode);
	    return groupMapper.deleteApply(applyInfo);
	}

    public Map<String, Object> getProgramCancelDate(String proCode) {
        return groupMapper.getProgramCancelDate(proCode);
    }

	public int insertRegister(String pRGRM_NM, String sCHDL_BGNG_YMD, String sCHDL_END_YMD, String gC_DT, int nOPE,
			String pRGRM_TYPE, String gC_OG_NM, String counselingContent, String posterContent, String userNumber) {
		Map<String, Object> registerInfo = new HashMap<>();
		registerInfo.put("pRGRM_NM", pRGRM_NM);
		registerInfo.put("sCHDL_BGNG_YMD", sCHDL_BGNG_YMD);
		registerInfo.put("sCHDL_END_YMD", sCHDL_END_YMD);
		registerInfo.put("gC_DT", gC_DT);
		registerInfo.put("nOPE", nOPE);
		registerInfo.put("pRGRM_TYPE", pRGRM_TYPE);
		registerInfo.put("gC_OG_NM", gC_OG_NM);
		registerInfo.put("counselingContent", counselingContent);
		registerInfo.put("posterContent", posterContent);
		registerInfo.put("userNumber", userNumber);
		
		return groupMapper.insertRegister(registerInfo);
	}

}
