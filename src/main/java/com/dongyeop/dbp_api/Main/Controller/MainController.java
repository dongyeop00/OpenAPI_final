package com.dongyeop.dbp_api.Main.Controller;

import com.dongyeop.dbp_api.OpenAPI.Entity.ProductEntity;
import com.dongyeop.dbp_api.OpenAPI.Service.ProductService;
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
    public String form(Model model){
        List<ProductEntity> products = productService.getAllProducts();
        System.out.println(products);
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/search")
    public String searchText(@RequestParam(name = "filter") String filter,
                         @RequestParam(name = "query") String query,
                         Model model){
        System.out.println(filter + " " +query);
        List<ProductEntity> productEntities = productService.getQueryProducts(filter,query);
        model.addAttribute("products",productEntities);
        return "index";
    }

    @PostMapping("/submit")
    public String searchButton(@RequestParam(name = "options", required = false) List<String> options){
        return null;
    }
}
