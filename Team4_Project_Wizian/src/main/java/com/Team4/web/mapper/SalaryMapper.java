package com.Team4.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.SalaryModel;

@Repository
@Mapper
public interface SalaryMapper {
	List<SalaryModel> getSalary();
}