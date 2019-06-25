package com.uetcodecamp.jwb01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TransfersController {
    /**
     * hàm dùng để vào trang chuyển tiền cho customer có id nào
     * @param modelMap
     * @param idCustomerTransfers là id của customer đang chuyển tiền, lấy từ formbank.jsp
     * @param session
     * @return
     */
    @PostMapping("/chuyentien")
    public String handleFormBank(ModelMap modelMap,
                                 @RequestParam(name = "idCustomerTransfers") Integer idCustomerTransfers,
                                 HttpSession session) {
        // lưu ID của customer đang chuyển tiền vào
        session.setAttribute("idCustomerTransfers", idCustomerTransfers);

        // thêm số tiền mà customer đang chuyển hiện có là bao nhiêu để kiểm tra nếu chuyển hơn tiền
        modelMap.addAttribute("maxMoney", Customers.lstCustomer.get(idCustomerTransfers-1).getBalance());
        return "chuyentien";
    }

    /**
     * hàm dùng để xử lý khi nhấn thực hiện chuyển tiền
     * @param modelMap
     * @param idCustmerReceive là id của customer nhận được tiền
     * @param moneyCustomerReceive là số tiền được chuyển đi hay chính là số tiền nhận được
     * @param session
     * @return
     */
    @PostMapping("/handleChuyenTien")
    public String handleChuyenChuyen(ModelMap modelMap,
                                     @RequestParam(name = "idCustmerReceive") Integer idCustmerReceive,
                                     @RequestParam(name = "moneyCustomerReceive") Integer moneyCustomerReceive,
                                     HttpSession session){
        // lấy id của customer đang  thực hiện chuyển tiền
        int idCustomerTransfers = (int)session.getAttribute("idCustomerTransfers");
        // thực hiện xóa session
        session.removeAttribute("idCustomerTransfers");
        // lấy customer có id = idCustomerTransfers ra
        Customer customerTransfers = Customers.lstCustomer.get(idCustomerTransfers-1);
        // nếu số tiền mà customerTransfers hiện có chuyển >= số tiền định chuyển thì chuyển thành công
        if(customerTransfers.getBalance() >= moneyCustomerReceive){
            // lấy customer có id = idCustmerReceive
            Customer customerReceive = Customers.lstCustomer.get(idCustmerReceive-1);
            // tăng tiền cho custmerReceive
            customerReceive.setBalance(customerReceive.getBalance() + moneyCustomerReceive);
            // giản tiền của customerTransfers
            customerTransfers.setBalance(customerTransfers.getBalance() - moneyCustomerReceive);
            // set lại những 2 customer trong list
            Customers.lstCustomer.set(idCustmerReceive - 1, customerReceive);
            Customers.lstCustomer.set(idCustomerTransfers - 1, customerTransfers);
            modelMap.addAttribute("customer", customerTransfers);
            return "formbank";
        }
        else{
            return "error";
        }
    }
}
