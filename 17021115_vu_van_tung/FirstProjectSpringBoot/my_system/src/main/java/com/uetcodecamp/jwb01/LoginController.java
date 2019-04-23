package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /**
     * hàm dùng để vào trang đăng nhập chuyển tiền
     * @param modelMap
     * @return
     */
    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        return "login";
    }

    /**
     * hàm dùng để customer với email và password == 1233456
     * @param emai
     * @param password
     * @return customer || null
     */
    private Customer findCustomer(String emai, String password){
        for (int i = 0; i < Customers.lstCustomer.size(); i++){
            Customer customerFind = Customers.lstCustomer.get(i);
            if (emai.equals(customerFind.getEmail())==true && password.equals("123456")){
                return customerFind;
            }
        }
        return null;
    }

    /**
     * hàm xử lý khi ấn đăng nhập
     * @param modelMap
     * @param email lấy trong input từ login.jsp
     * @param password lấy trong input từ login.jsp
     * @return
     */
    @PostMapping("/handleLogin")
    public String handleLogin(ModelMap modelMap,
                              @RequestParam(name = "email-login") String email,
                              @RequestParam(name = "password-login") String password){
        // tìm customer theo email và password
        Customer customerFind = findCustomer(email, password);

        // nếu tìm được thì vào trang chuyển tiền
        if (customerFind != null){
            modelMap.addAttribute("customer", customerFind);
            return "formbank";
        }
        // không đăng nhập được thì thông báo lỗi
        return "error";
    }
}
