package com.Team4.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder @Data
public class SalaryModel {	
	private int id;	
	@NonNull @Builder.Default private String name = "NULL NAME";
	private String email;
}