package com.team.project2.notice.dto;


import java.util.Date;

import lombok.Data;

@Data
public class Notice {
	
	private Integer noticeIdx;
	private String notice;
	private String content;
	private Date writeDate;


}
