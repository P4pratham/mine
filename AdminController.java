package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorService service;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in list vendor");
		// save vendor under model map
		map.addAttribute("vendor_list", service.listVendors());
		return "/admin/list"; //forward view name
	}
	@GetMapping("/add")
	public String AddVendorForm(Model map) {
		System.out.println("in list vendor");
		// save vendor under model map
		map.addAttribute("vendor_list", service.listVendors());
		return "/admin/register"; //forward view name
	}
	@PostMapping("/add")
	private String processVendorForm(Model map, 
			@RequestParam String email,
			@RequestParam String password,@RequestParam String name,@RequestParam String city,@RequestParam String phoneNo,
			@RequestParam double regAmount){
		// TODO process the incoming values
		Vendor v=  new Vendor( name,  email,  password, "vendor",  city, phoneNo,
				 regAmount, null);
		map.addAttribute("vendor_register", service.registerVendor(v));
		return "redirect:/admin/list";
	}
	@GetMapping("/delete")
	public String deleteVendor(HttpSession hs,@RequestParam int id) {
		System.out.println("in delete vendor");
		// save vendor under model map
		hs.setAttribute("dltd_id",id);
		service.deleteVendor(id);
		hs.setAttribute("status", "deleted successfully");
		//map.addAttribute("vendor_delete", service.deleteVendor(id));
		//map.addAttribute("status", "deleted successfully");
		return "redirect:/admin/list"; //forward view name
	}
	
}
