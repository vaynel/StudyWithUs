package com.team.project2.studyRoom.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.project2.studyRoom.dto.StudyNote;
import com.team.project2.studyRoom.service.StudyRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudyRoomController {
	
	private final StudyRoomService studyRoomService;
	
	@PostMapping("studyRoom/api/noteWrite")
	@ResponseBody
	public void noteWrite(@RequestBody StudyNote note) {
		System.out.println("노트 작성");
		System.out.println(note);
		String userId = "테스트1";
		studyRoomService.insertStudyNote(note,userId);
		
		
	}

}
