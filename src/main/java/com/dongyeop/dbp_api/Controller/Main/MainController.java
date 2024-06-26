package com.dongyeop.dbp_api.Controller.Main;

import com.dongyeop.dbp_api.Entity.Product.ProductEntity;
import com.dongyeop.dbp_api.Service.Product.ProductService;
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

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/search")
    public String searchText(@RequestParam(name = "filter") String filter,
                             @RequestParam(name = "query") String query,
                             Model model) {
        List<ProductEntity> productEntities = productService.getQueryProducts(filter, query);
        model.addAttribute("products", productEntities);
        return "list";
    }

    @PostMapping("/submit")
    public String searchButton(@RequestParam(name = "selectedValues", required = false) List<String> options, Model model) {
        List<ProductEntity> productEntities = productService.getOptionProducts2(options);
        model.addAttribute("products", productEntities);
        model.addAttribute("selectedValues", options);
        return "list";
    }


}
