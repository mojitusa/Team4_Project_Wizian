package com.Team4.web.service;

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
}
