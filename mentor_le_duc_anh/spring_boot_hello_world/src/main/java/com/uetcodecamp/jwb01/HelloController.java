package com.uetcodecamp.jwb01;

import com.uetcodecamp.jwb01.model.Category;
import com.uetcodecamp.jwb01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private List<String> items = new ArrayList<>();

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("items", items);

        Category category = categoryService.getFirstCategory();
//        System.out.println(category.getTitle());

        return "home";
    }

    @GetMapping(value = "/add")
    public String addName(@RequestParam(value = "name") String name) {
        items.add(name);
        return "redirect:/";
    }

    @GetMapping(value = "product/{productId}")
    public String product(@RequestParam(value = "name", required = false, defaultValue = "none") String name,
                          @RequestParam(value = "phone") String phone,
                          @PathVariable String productId) {
        System.out.println("name: " + name + ", phone: " + phone + ",productId: " + productId);
        return "home";
    }

    @PostMapping(value = "product")
    public String productAdd(@RequestBody Category category) {
        System.out.println(category.toString());
        return "redirect:/";
    }
}