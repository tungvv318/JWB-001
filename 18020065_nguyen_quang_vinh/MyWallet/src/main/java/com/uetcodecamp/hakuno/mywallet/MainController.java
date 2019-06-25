package com.uetcodecamp.hakuno.mywallet;

import com.uetcodecamp.model.Database;
import com.uetcodecamp.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

@Controller
public class MainController {
    private int loginID = 0;

    public Database database = new Database();

    @RequestMapping("/")
    public String index() { return "hello"; }

    @RequestMapping("/recent")
    public String Table(Model model, HttpServletResponse response ) throws IOException {
        String message = "Welcome to My Wallet" ;

        model.addAttribute("message", message) ;
        model.addAttribute("container", database.getMembers()) ;
        return "table";
    }

    @RequestMapping("/recent/add")
    public String AddingAccount(Model model) {
        return "register";
    }

    @PostMapping("/recent/add")
    public String SaveDetail(@RequestParam("user") String username,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("balance") String balance) {
        database.addUser(username, email, phone, Integer.parseInt(balance)); ;
        return "registerSuccess";
    }

    @RequestMapping("/login")
    public String RedirectToLogin(Model model) {
        if (this.loginID != 0) return "redirect:/personal";
        return "login" ;
    }

    @PostMapping("/login")
    public String ValidateLogin(@RequestParam("email") String email,
                                 @RequestParam("pass") String password,
                                 Model model) {
        this.loginID = database.validateLogin(email, password);
        if (this.loginID == 0) return "LoginFailed";

        return "redirect:" + "/personal";
    }

    @RequestMapping("/personal")
    public String PersonalPage(Model model) {
        if (this.loginID == 0) return "WrongAccess";

        UserInfo RecentUser = database.getUser(this.loginID) ;

        model.addAttribute("name", RecentUser.getName());
        model.addAttribute("email", RecentUser.getEmail());
        model.addAttribute("phone", RecentUser.getPhone());
        model.addAttribute("balance", RecentUser.getBalance());

        return "personal";
    }

    @RequestMapping("/transfer")
    public String LoadTransferMoney() {
        if (this.loginID == 0) return "WrongAccess";
        return "Transfer";
    }

    @RequestMapping("/testing")
    public String Redirect() {
        return "redirect:" + "/transfer" ;
    }

    @PostMapping("/transfer")
    public String ProcessTransfer(@RequestParam("ID") int ID,
                                  @RequestParam("money") int money,
                                  Model model) {

        if (!database.transferMoney(this.loginID, ID, money)) {
            model.addAttribute("color", "red");
            model.addAttribute("message", "Transfer Failed");
        } else {
            model.addAttribute("color", "green");
            model.addAttribute("message", "Transfer Success");
        }

        return "TransferStatus";
    }

    @PostMapping("/delete")
    public String Delete (@RequestParam("ID") int ID) {
        if (this.loginID == ID) this.loginID = 0;
        if (database.deleteUser(ID)) return "Success";
        return "Failed";
    }

    @RequestMapping("/edit")
    public String EditProfile (@RequestParam("ID") int ID,
                               Model model) {

        //if (id != this.loginID) return "Failed" ;
        UserInfo RecentUser = database.getUser(ID);
        model.addAttribute("ID",RecentUser.getID());
        model.addAttribute("name", RecentUser.getName());
        model.addAttribute("email", RecentUser.getEmail());
        model.addAttribute("phone", RecentUser.getPhone());
        model.addAttribute("balance", RecentUser.getBalance());
        model.addAttribute("ID", RecentUser.getID());

        return "EditProfile";
    }

    @PostMapping("/edit")
    public String EditSaving (@RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("balance") int balance,
                              @RequestParam("ID") int ID) {
        if (this.database.editUser(ID, name.trim(), email.trim(), phone.trim(), balance)) return "redirect:/recent";
        return "Failed";
    }
}
