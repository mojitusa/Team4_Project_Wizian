package com.Team4.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.GroupModel;

@Repository
@Mapper
public interface GroupMapper {
	List<GroupModel> getCategory();

	List<Map<String, Object>> getgcList();

	List<Map<String, Object>> getproDetail(int procd);

	int insertApply(Map<String, Object> applyInfo);

	int checkDuplicate(Map<String, Object> applyInfo);

	int deleteApply(Map<String, Object> applyInfo);

}