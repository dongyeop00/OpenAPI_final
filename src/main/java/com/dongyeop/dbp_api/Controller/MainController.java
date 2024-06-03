package com.dongyeop.dbp_api.Controller;

import com.dongyeop.dbp_api.Entity.ProductEntity;
import com.dongyeop.dbp_api.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @GetMapping("/asd")
    public String form(Model model) {
        List<ProductEntity> products = productService.getAllProducts();
        System.out.println(products);
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/search")
    public String searchText(@RequestParam(name = "filter") String filter,
                             @RequestParam(name = "query") String query,
                             Model model) {
        System.out.println(filter + " " + query);
        List<ProductEntity> productEntities = productService.getQueryProducts(filter, query);
        model.addAttribute("products", productEntities);
        return "list";
    }

    @PostMapping("/submit")
    public String searchButton(@RequestParam(name = "selectedValues", required = false) List<String> options, Model model) {
        System.out.println(options);
        List<ProductEntity> productEntities = productService.getOptionProducts2(options);
        model.addAttribute("products", productEntities);
        model.addAttribute("selectedValues", options);
        return "list";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }


}
