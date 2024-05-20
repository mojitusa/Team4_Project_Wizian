package com.Team4.web.model;

import lombok.Data;

@Data
public class BoardModel {

	private int CSL_NO, CSL_STATUS;
	private String CSL_TITLE, CSL_CONTENT, CSL_ASNWER, CSL_CATEGORY,
	CSL_DATE, CSL_EMAIL, CSL_EVAL;
}
