package com.Team4.web.service;

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

	public int deleteApply(String studNumber, String proCode) {
	    Map<String, Object> applyInfo = new HashMap<>();
	    applyInfo.put("studNumber", studNumber);
	    applyInfo.put("proCode", proCode);
	    return groupMapper.deleteApply(applyInfo);
	}

}
