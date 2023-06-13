package com.team.project2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserDAO> getUserList() {
        return userMapper.getUserList();
    }

    public UserDAO getUserById(String id) {
        return userMapper.getUserById(id);
    }

    public UserDAO getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public UserResponses getUsernameByEmail(String email) {
        return userMapper.getUsernameByEmail(email);
    }

    public void signup(UserDAO userDAO) { // 회원 가입
        if (!userDAO.getId().equals("") && !userDAO.getEmail().equals("")) {
            // password는 암호화해서 DB에 저장
            userDAO.setPassword(passwordEncoder.encode(userDAO.getPassword()));
            userMapper.insertUser(userDAO);
        }
    }

    public void edit(UserDAO userDAO) { // 회원 정보 수정
        // password는 암호화해서 DB에 저장
        userDAO.setPassword(passwordEncoder.encode(userDAO.getPassword()));
        userMapper.updateUser(userDAO);
    }

    public void withdraw(String id) { // 회원 탈퇴
        userMapper.deleteUser(id);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
