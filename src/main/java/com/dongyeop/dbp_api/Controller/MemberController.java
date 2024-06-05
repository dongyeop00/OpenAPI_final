package com.dongyeop.dbp_api.Controller;

import com.dongyeop.dbp_api.DTO.UserDTO;
import com.dongyeop.dbp_api.DTO.UserLoginDTO;
import com.dongyeop.dbp_api.Entity.UserCheckboxValueEntity;
import com.dongyeop.dbp_api.Entity.UserEntity;
import com.dongyeop.dbp_api.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDTO userDTO, HttpSession session, Model model){
        System.out.println(userDTO);
        UserLoginDTO userLoginDTO = userService.login(userDTO);
        if(userLoginDTO != null){
            session.setAttribute("user",userLoginDTO);
            System.out.println("session : " + userLoginDTO);
            System.out.println(session);
            return "redirect:/";
        }else{
            return "login";
        }
    }

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserDTO userDTO){
        userService.saveUser(userDTO);
        return "main";
    }

}
