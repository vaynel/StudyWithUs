package com.team.project2.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // User 테이블 가져오기
    List<UserDAO> getUserList();

    // 회원 가입
    void insertUser(UserDAO userDAO);

    // 회원 정보 가져오기
    UserDAO getUserByEmail(String email);

    UserResponses getUsernameByEmail(String email);

    UserDAO getUserById(String id);

    // 회원 정보 수정
    void updateUser(UserDAO userDAO);

    // 회원 탈퇴
    void deleteUser(String id);
}

