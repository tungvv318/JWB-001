package com.uetcodecamp.jwb01;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    /**
     * hàm dùng vào trang hiển thị khách hàng home.jsp
     * @param modelMap dùng để thêm attribute là lstCustomer hiện thị ở trang home.jsp
     * @return chuyển đến home.jsp
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("lstCustomer", Customers.lstCustomer);
        return "home";
    }


    /**
     * hàm dùng để điều hướng sang các trang thêm khách hàng || sửa thông tin khách hàng
     * @param model
     * @param session
     * @param addCustomer được lấy từ home.jsp rồi hiển thị lên URL có thể không có khi mình bấm nút khác
     * @param editCustomer được lấy từ home.jsp rồi hiển thị lên URL có thể không có khi mình bấm nút khác
     * @param idCustomerEdit lấy từ home.jsp dùng để biết mình sẽ sửa customer có id là gì,
     *                       có thể không có khi mình chưa thực hiện bấm nút sửa
     * @return formadd.jsp || formedit.jsp
     */
    @PostMapping("/handle")
    public String handleForm(ModelMap model, HttpSession session,
                             @RequestParam(name = "addCustomer", required = false) String addCustomer,
                             @RequestParam(name = "editCustomer", required = false) String editCustomer,
                             @RequestParam(name = "idCustomerEdit", required = false) Integer idCustomerEdit){
        if (addCustomer != null){
            // thêm một customer không có thông tin để khi thêm thông tin vào thì nó sẽ được ghi đè
            model.addAttribute("customerAdd", new Customer());
            return "formadd";
        }
        else{
            if (editCustomer != null){
                // lưu vào modelAttribute để hiển thị sang trang formedit.jsp
                model.addAttribute("customerEdit", Customers.lstCustomer.get(idCustomerEdit-1));
                // lưu vào session để lấy id khi xử l
                session.setAttribute("idCustomerEdit", idCustomerEdit);
                return "formedit";
            }
        }
        return "error";
    }



}