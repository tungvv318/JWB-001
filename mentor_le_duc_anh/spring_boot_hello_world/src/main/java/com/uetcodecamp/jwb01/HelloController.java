package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("name", name);
        return "home";
    }

}