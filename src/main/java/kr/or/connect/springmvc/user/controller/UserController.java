package kr.or.connect.springmvc.user.controller;

import kr.or.connect.springmvc.user.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/regist")
    public String userForm() {
        return "user/userForm";
    }

    @PostMapping("/regist")
    public String userRegist(@ModelAttribute User user) {
        System.out.println(user);

        return "user/userResult";
    }
}
