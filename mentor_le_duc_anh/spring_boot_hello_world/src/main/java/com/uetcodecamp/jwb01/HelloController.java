package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private List<String> items = new ArrayList<>();

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping(value = "/add")
    public String addName(@RequestParam(value = "name") String name) {
        items.add(name);
        return "redirect:/";
    }

}