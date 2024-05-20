package com.Team4.web.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FileModel {

	private int file_no, file_sn;
	private long file_sz;
	private String actl_file_nm, uuid_file_Nm, file_path_nm, file_extn_nm;
}
