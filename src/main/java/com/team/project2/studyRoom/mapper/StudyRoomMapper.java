package com.team.project2.studyRoom.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyRoomMapper {

	
	@Insert("insert into study_note(title,content,user_id) values(#{note.title},#{note.content},#{userId}) ")
	void insertStudyNote(Map<String, Object> command);

}
