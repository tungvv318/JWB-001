package com.anonyhostvn.springboot;

import com.anonyhostvn.model.MocksData; 
import com.anonyhostvn.model.InfoPattern ;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//template engine
@Controller
public class MainController {
	private int IDLogined = 0 ; 
	
	public MocksData Data = new MocksData() ; 
	
	@RequestMapping("/")
	public String index () {
		return "hello" ; 
	}
	
	@RequestMapping("/page1")
	public String Table (Model model,
			HttpServletResponse response ) throws IOException {
		
		String message = "Welcome to Anony Bank" ;

		model.addAttribute("message" , message) ;
		model.addAttribute("container" , Data.getMembership()) ; 
		return "table" ;
	}
	
	@RequestMapping("/page1/add")
	public String AddingAccount (Model model) {
		return "register" ;
	}

	@PostMapping("/page1/add")
	public String SaveDetail (@RequestParam("user") String username , 
							  @RequestParam("phone") String phone ,
							  @RequestParam("email") String email , 
							  @RequestParam("balance") String balance) { 
		Data.AddNewMember(username, email, phone, Integer.parseInt(balance) , false) ;
		return "registerSuccess" ; 
	}
	
	@RequestMapping("/login") 
	public String RedirectToLogin (Model model) {
		if (this.IDLogined != 0) return "redirect:/personal" ; 
		return "login" ; 
	}
	
	@PostMapping("/login")
	public String ValidateLogin (@RequestParam("email") String email,
								 @RequestParam("pass") String pass ,
								 Model model) {
		this.IDLogined = Data.ValidateLogin(email, pass) ; 
		if (this.IDLogined == 0) return "LoginFailed" ; 
		
		return "redirect:" + "/personal" ;
	}
	
	@RequestMapping("/personal")
	public String PersonalPage (Model model) {
		if (this.IDLogined == 0) return "WrongAccess" ; 
		
		InfoPattern RecentUser = Data.getUser(this.IDLogined) ;
		
		model.addAttribute("name" , RecentUser.getName()) ; 
		model.addAttribute("email", RecentUser.getEmail()) ; 
		model.addAttribute("phone", RecentUser.getPhone()) ; 
		model.addAttribute("balance", RecentUser.getBalance()) ;
		
		return "personal" ; 
	}
	
	@RequestMapping("/transfer")
	public String LoadTransferMoney () {
		if (this.IDLogined == 0) return "WrongAccess" ; 
		return "Transfer" ; 
	}
	
	@RequestMapping("/testing")
	public String Redirect () {
		return "redirect:" + "/transfer" ; 
	}
	
	@PostMapping("/transfer")
	public String ProcessTransfer(@RequestParam("ID") int ID ,
								  @RequestParam("money") int money , 
								  Model model) {
				
		if (!Data.TransferMoney(this.IDLogined, ID, money)) {
			model.addAttribute("color", "red") ; 
			model.addAttribute("message", "Transfer Failed") ; 
		} else {
			model.addAttribute("color", "green") ; 
			model.addAttribute("message", "Transfer Success") ; 
		}
		
		return "TransferStatus" ; 
	}
}
