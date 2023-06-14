package com.team.project2.studyRoom.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.team.project2.studyRoom.dto.StudyNote;
import com.team.project2.studyRoom.mapper.StudyRoomMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyRoomServiceImpl implements StudyRoomService{
	
	private final StudyRoomMapper studyRoomMapper;
	
	
	@Override
	public void insertStudyNote(StudyNote note, String userId) {
		Map<String, Object> command = new HashMap<String, Object>();
		command.put("note", note);
		command.put("userId",userId);
		System.out.println(command);
		System.out.println((StudyNote)command.get("note"));
		studyRoomMapper.insertStudyNote(command);
		
	}

}
