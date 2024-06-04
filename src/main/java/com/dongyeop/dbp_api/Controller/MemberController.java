package com.dongyeop.dbp_api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "userName") String username,
                       @RequestParam(name = "userNickname") String usernickname,
                       @RequestParam(name = "userEmail") String useremail,
                       @RequestParam(name = "userPassword") String userpassword,
                       @RequestParam(name = "userGender") String usergender,
                       @RequestParam(name = "selectedValues") List<String> options){


        return null;
    }

}
