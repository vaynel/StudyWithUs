package com.team.project2.notice.service;

import java.util.List;

import com.team.project2.notice.dto.Notice;

public interface NoticeService {

    void insertNotice(Notice notice);

	Notice readNotice(int noticeIdx);

	List<Notice> readAllNotice();

	String updateNotice(Notice notice);

	Integer delectNotice(Notice notice);

}
