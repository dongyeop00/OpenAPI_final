package com.dongyeop.dbp_api.Controller.User;

import com.dongyeop.dbp_api.DTO.User.UserDTO;
import com.dongyeop.dbp_api.DTO.User.UserLoginDTO;
import com.dongyeop.dbp_api.Entity.Product.ProductEntity;
import com.dongyeop.dbp_api.Service.Product.ProductService;
import com.dongyeop.dbp_api.Service.User.UserCheckboxValueService;
import com.dongyeop.dbp_api.Service.User.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserCheckboxValueService userCheckboxValueService;
    private final ProductService productService;

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

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        UserDTO userDTO = userService.findById(id);
        String[] values = userCheckboxValueService.findCheckboxValuesByUserId(id);
        ProductEntity[] product = new ProductEntity[values.length];

        for (int i = 0; i < values.length; i++) {
            product[i] = productService.getRandomOptionProduct(values[i]);
        }

        model.addAttribute("product",product);
        model.addAttribute("values",values);
        model.addAttribute("user", userDTO);
        return "detail";
    }

}
