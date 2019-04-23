package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private List<User> items = new ArrayList<>();
    User session;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("add")
    public String indexAdd()
    {
        return "formAdd";
    }
    @PostMapping("submitFormAdd")
    public String submitFormAdd(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("balance") int balance) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setBalance(balance);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        items.add(newUser);
        return "redirect:/";
    }

    @GetMapping("login")
    public String indexLogin()
    {
        return "login";
    }
    @PostMapping("submitLogin")
    public String submitLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model resLogin) {
        for(int i = 0; i < items.size(); i++)
        {
            if(password.equals("123456") && email.equals(items.get(i).getEmail())) {
                session = items.get(i);
                return "redirect:/profile";
            }
        }
        resLogin.addAttribute("messLogin", "Đăng nhập không thành công!");
        return "login";
    }

    @RequestMapping("profile")
    public String indexProfile(Model model)
    {
        model.addAttribute("session", session);
        return "profile";
    }

    @GetMapping("transfer")
    public String indexTranfer()
    {
        return "transfer";
    }

    @PostMapping("submitTransfer")
    public String submitTranfer(@RequestParam("id") int id,
                              @RequestParam("balance") int balance,
                              Model resTransfer) {
        id--;
        int myBalance = session.getBalance();
        if(id < items.size() && id >= 0 && myBalance - balance >= 0){
            session.setBalance(myBalance - balance);
            items.get(id).setBalance(items.get(id).getBalance() + balance);
            return "redirect:/profile";
        }
        else if(myBalance - balance < 0){
            resTransfer.addAttribute("messTransfer", "LỖI: Số dư trong tài khoản không đủ!");
            return "transfer";
        }
        else {
            resTransfer.addAttribute("messTransfer", "LỖI: ID không tồn tại!");
            return "transfer";
        }
    }
}