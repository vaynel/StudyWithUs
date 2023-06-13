package com.team.project2.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.project2.notice.dto.Notice;
import com.team.project2.notice.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeMapper noticeMapper;

	@Override
	public void insertNotice(Notice notice) {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public Notice readNotice(int noticeIdx) {
		Notice notice = noticeMapper.selectNotice(noticeIdx);
		return notice;

	}

	@Override
	public List<Notice> readAllNotice() {
		return noticeMapper.selectAllNotice();
	}

	@Override
	public String updateNotice(Notice notice) {
		noticeMapper.updateNoticeByIdx(notice);
		return "수정 성공";
	}

	@Override
	public Integer delectNotice(Notice notice) {
		return noticeMapper.deleteNotice(notice);
	}

}
