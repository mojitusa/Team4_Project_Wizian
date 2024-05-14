package com.Team4.web.model;


import lombok.Data;

@Data
public class FileModel {

	int file_no, file_sn;
	long file_sz;
	String actl_file_nm, uuid_file_Nm, file_path_nm, file_extn_nm;
}
