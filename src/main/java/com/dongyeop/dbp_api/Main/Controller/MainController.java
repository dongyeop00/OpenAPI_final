package com.dongyeop.dbp_api.Main.Controller;

import com.dongyeop.dbp_api.OpenAPI.Entity.ProductEntity;
import com.dongyeop.dbp_api.OpenAPI.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @GetMapping("/")
    public String form(Model model){
        List<ProductEntity> products = productService.getAllProducts();
        System.out.println(products);
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }
}
