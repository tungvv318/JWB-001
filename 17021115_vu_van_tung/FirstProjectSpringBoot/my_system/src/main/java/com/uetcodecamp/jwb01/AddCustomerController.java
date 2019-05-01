package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddCustomerController {
    /**
     * hàm dùng để xử lý khi thêm customer
     * @param customerAdd lấy dữ liệu từ modelAttribute ở trang formadd.jsp
     * @return chuyển về trang chủ
     */
    @PostMapping("/handleAddCustomer")
    public String handleFormAdd(@ModelAttribute("customerAdd") Customer customerAdd){
        // số ID của customer sẽ thêm vào chính là size của lstCustomer
        customerAdd.setId(Customers.lstCustomer.size()+1);
        Customers.lstCustomer.add(customerAdd);
        return "redirect:/";
    }
}
