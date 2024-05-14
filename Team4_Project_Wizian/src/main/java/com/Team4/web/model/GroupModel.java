package com.Team4.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder @Data
public class GroupModel {	
	private String PRGRM_CD, GC_OG_NM, USER_NO, SCHDL_BGNG_YMD, SCHDL_END_YMD, GC_DT, 
				   PRGRM_NM, GC_CONTS_CN, GC_DTL_CN, PRGRM_TYPE;
	private int NOPE, APPLY_CNT;
	
	
}