package com.Team4.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.ProfCslInsertModel;

@Repository
@Mapper
public interface ProfCslInsertMapper {

	void insertProfCslData(ProfCslInsertModel profCslInsertModel);

	List<Map<String, Object>> searchProfDepartment(String department);

}