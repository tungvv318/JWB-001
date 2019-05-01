package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EditCustomerController {
    /**
     * hàm dùng để xử lý sự kiện khi Edit 1 thông tin của một customer
     * @param session dùng để lấy ID của customer vừa Edit
     * @param customerEdit là 1 Customer có id = 0 được lấy từ formedit.jsp
     * @return chuyển sang trang hiển thị danh sách customer
     */
    @PostMapping("/handleEditCustomer")
    public String handleFormEdit(HttpSession session,
                                 @ModelAttribute("customerEdit") Customer customerEdit){

        // lấy ID của customer trong session được lưu vào ở trong HomeController
        int idCustomerEdit = (int)session.getAttribute("idCustomerEdit");
        // lấy xong ID thì xóa session
        session.removeAttribute("idCustomerEdit");
        // thực hiện thay đổi ID từ = 0 sang id đã nhận
        customerEdit.setId(idCustomerEdit);
        // set lại phần tử trong list
        Customers.lstCustomer.set(idCustomerEdit-1, customerEdit);
        return "redirect:/";
    }
}
