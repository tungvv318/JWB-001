package com.uetcodecamp.jwb;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.uetcodecamp.jwb.Model.MockUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    public MockUser users = new MockUser();
    boolean login=false;
    int idLogin = 0;
    int editId = 0;

    @RequestMapping("/")
    public String index(Model model,
                        HttpServletResponse response) throws IOException {
        model.addAttribute("users", users.getUsers());
        return "home";
    }

    @GetMapping("/add")
    public  String indexAdd() {
        return "add";
    }
    @PostMapping("submitAdd")
    public String submitAdd(@RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam("balance") long balance) {
        users.addUser(name, email, phone, balance);

        return "redirect:/";
    }
    @GetMapping("/login")
    public String indexLogin() {
        return "login";
    }
    @PostMapping("submitLogin")
    public String submitLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                                Model resLogin) {
            this.idLogin = users.login(email, password);
            if(this.idLogin != 0) {
                return "redirect:/profile";
        }
        resLogin.addAttribute("messLogin", "Email or password is not true");
        return "login";

    }

    @RequestMapping("profile")
    public String indexProfile(Model model) {
        User loginUser = users.getUser(this.idLogin);
        model.addAttribute("name", loginUser.getName());
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("phone", loginUser.getPhone());
        model.addAttribute("balance", loginUser.getBalance());
        return "profile";
    }
    @GetMapping("transfers")
    public String indexTranfer() {
        return "transfers";
    }
    @PostMapping("submitTransfers")
    public String submitTransfers(@RequestParam("id") int id,
                                  @RequestParam("balance") long balance,
                                  Model model) {
            if(!users.Transfer(this.idLogin, id, balance)) {
                model.addAttribute("color", "red");
                model.addAttribute("message", "Transfer failed!");
                return "transfers";
            }
            else {
                return "redirect:/profile";
            }

    }
    @RequestMapping("/edit")
    public  String indexEdit(@RequestParam("id") int id,
                             Model model) {
        this.editId = id;
        User editUser = users.getUser(id);
        model.addAttribute("name", editUser.getName());
        model.addAttribute("email", editUser.getEmail());
        model.addAttribute("phone", editUser.getPhone());
        model.addAttribute("balance", editUser.getBalance());

        return "edit";
    }
    @PostMapping("submitEdit")
    public String submitEdit(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("balance") long balance) {
        User editUser = users.getUser(this.editId);
        editUser.setName(name);
        editUser.setEmail(email);
        editUser.setPhone(phone);
        editUser.setBalance(balance);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String Delete (@RequestParam("id") int id) {
        if(this.idLogin == id) {
            this.idLogin = 0;
        }
        users.DeleteUser(id);
        return "redirect:/";
    }
}