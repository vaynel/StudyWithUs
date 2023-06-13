package com.team.project2.notice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.project2.notice.dto.Notice;
import com.team.project2.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NoticeController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private final NoticeService noticeService;

	// post로 바꿔야함
	@PostMapping("newNotice")
	public void writeNotice1(Notice notice) {
		log.info("Controller : noticeWrite");
		noticeService.insertNotice(notice);
	}

	@GetMapping("selectNotice")
	public void readNotice() {
		int noticeIdx = 1;
		log.info("Conroller : readNotice");
		Notice notice = noticeService.readNotice(noticeIdx);
		System.out.println(notice);
	}

	@GetMapping("menu/api/notice/AllNotice")
	public List<Notice> AllNotice() {
		log.info("Conroller : AllNotice");
		List<Notice> notices = noticeService.readAllNotice();
		System.out.println(notices);
		return notices;
	}

	@GetMapping("api/notice/AllNotice")
	public List<Notice> AllNotice1() {
		log.info("Conroller : AllNotice");
		List<Notice> notices = noticeService.readAllNotice();
		System.out.println(notices);
		return notices;
	}

	@GetMapping("notice/api/notice/AllNotice")
	public List<Notice> AllNotice2() {
		log.info("Conroller : AllNotice");
		List<Notice> notices = noticeService.readAllNotice();
		System.out.println(notices);
		return notices;
	}

	@PostMapping("notice/api/notice/newNotice")
	@ResponseBody
	public String writeNotice(@RequestBody Notice notice) {
		log.info("Controller : noticeWrite");
		System.out.println(notice);
		noticeService.insertNotice(notice);
		return "작성성공";
	}

	@PostMapping("notice/api/notice/noticeUpdate")
	@ResponseBody
	public String noticeUpdate(@RequestBody Notice notice) {
		log.info("Controller : noticeUpdate");
		System.out.println(notice);
		noticeService.updateNotice(notice);
		return "수정 성공";
	}

	@PostMapping("notice/api/notice/noticeDelete")
	@ResponseBody
	public String noticeDelete(@RequestBody Notice notice) {
		log.info("Controller : noticeDelete");
		int delect = noticeService.delectNotice(notice);
		System.out.println(delect + "개의 공지사항이 삭제됨");
		return "삭제 성공";
	}

}
