package com.uetcodecamp.vuvanhoc.controller;

import com.uetcodecamp.vuvanhoc.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class SystemController {
	HashMap<Integer, User> items = new HashMap<>();
	private int templateId;
	@RequestMapping(value = {"/"})
	public String index(Model model) {
		model.addAttribute("items", items);
		return "home";
	}
	@GetMapping(value = "/them-nguoi-dung")
	public String formGet(){
		return "themUser";
	}
	@PostMapping(value = "/them-nguoi-dung")
	public String formPost(@RequestParam String name, @RequestParam String email,
	                       @RequestParam String phone, @RequestParam int balance){
		User newUser = new User(name, email, phone, balance);
		newUser.setId(templateId);
		templateId++;
		items.put(newUser.getId(), newUser);
		return "redirect:/";
	}

	@GetMapping(value = "/sua-thong-tin/{key}")
	public String formUpdateGet(@PathVariable("key") int key, Model model){
		model.addAttribute("key", key);
		model.addAttribute("items", items);
		return "suaThongTin";
	}
	@PostMapping(value = "/sua-thong-tin/{key}")
	public String formUpdatePost(@PathVariable("key") int key, @RequestParam String name, @RequestParam String email,
	                       @RequestParam String phone, @RequestParam int balance){

		items.get(key).setName(name);
		items.get(key).setPhone(phone);
		items.get(key).setEmail(email);
		items.get(key).setBalance(balance);
		return "redirect:/";
	}
	@GetMapping(value = "/dang-nhap")
	public String formLoginGet(){
		return "dangNhap";
	}
	@GetMapping(value = "/thong-tin-nguoi-dung/{key}")
	public String formLoginPost(@PathVariable("key") int key, Model model){
		model.addAttribute("items", items);
		model.addAttribute("key", key);
		return "thongTinTK";
	}
	@PostMapping(value = "/xu-li-dang-nhap")
	public String xuLiDangNhap(@RequestParam String email, @RequestParam String password, Model model){
		String defaultPassword = "123456";
		for(int i : items.keySet()){
			if(items.get(i).getEmail().equals(email) && password.equals(defaultPassword)){
				System.out.println("dang nhap thanh cong");
				return "redirect:/thong-tin-nguoi-dung/" + i;
			}
		}
//		System.out.println("dang nhap sai roi");
		return "thongBao/error";
	}
	@PostMapping(value = "/giao-dich/{key}")
	public String chuyenTien(@PathVariable("key") int key, Model model){
		model.addAttribute(key);
		return "formChuyenTien";
	}
	@PostMapping(value = "/xu-li-giao-dich/{key}")
	public String xuLiGiaoDich(@PathVariable("key") int key,
	                           @RequestParam int id, @RequestParam int amount) {
		final int soDuToiThieu = 50000;
		if (items.get(key).getBalance() - amount < soDuToiThieu) {
			System.out.println("chuyen tien that bai");
			return "thongBao/loiGiaoDich";
		} else {
			for (int i : items.keySet()) {
				if (items.get(i).getId() == id) {
					items.get(i).setBalance(items.get(i).getBalance() + amount);
					items.get(key).setBalance(items.get(key).getBalance() - amount);
					return "redirect:/";
				}
			}
		}
		return "thongBao/idNotFound";
	}



}