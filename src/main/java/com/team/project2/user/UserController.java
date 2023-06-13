package com.team.project2.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    // 회원가입
    @RequestMapping(value = "api/user/signup", method = RequestMethod.POST, consumes="application/json;")
    public void userRegister(@RequestBody UserDAO userDAO) {

        // 유저 코드 생성
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String id;

        for (int i = 0; i < 4; i++) {
            String randomNum = Integer.toString(random.nextInt(10));
            sb.append(randomNum);
        }

        id = sb.toString();

        userDAO.setId(userDAO.getNickname() + "#" + id);
        userDAO.setRole("USER");

        userService.signup(userDAO);
    }
    @GetMapping("/api/user/login/success")
    public ResponseEntity success () {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("result", 1);

        return ResponseEntity.ok(map);
    }
    @GetMapping("/api/user/login/fail")
    public ResponseEntity fail () {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("result", -1);

        return ResponseEntity.ok(map);
    }

//    @PostMapping("/sign-up")
//    public String signup(userDAO userDAO) {
//        userService.signup(userDAO); // 중복검사 기능 추가하기
//        return "redirect:/"; // 로그인 페이지로 이동
//    }
//
//    // 회원 정보 수정
//    @GetMapping(value = "/update")
//    public String editPage(Model model) {
//        String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        userDAO userDAO = userService.getUserById(id);
//        model.addAttribute("user", userDAO);
//        return ""; // 수정 페이지
//    }
//
//    @PostMapping(value = "/delete")
//    public String withdraw(HttpSession session) {
//        String id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (id != null) {
//            userService.withdraw(id);
//        }
//
//        SecurityContextHolder.clearContext();
//        return "redirect:/"; // 회원 탈퇴 후 나오는 화면
//    }

}

