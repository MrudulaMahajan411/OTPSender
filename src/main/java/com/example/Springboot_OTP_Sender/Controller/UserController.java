package com.example.Springboot_OTP_Sender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Springboot_OTP_Sender.Service.OTPservice;
import com.example.Springboot_OTP_Sender.Service.UserService;


@Controller
public class UserController {
	String otp1;
	@Autowired
	private UserService userService;
	@Autowired
	private OTPservice otpservice;

	@GetMapping("/adminlogin")
	public String getlogin(Model model) {
		return "adminlogin";	
	}
	
	@GetMapping("/loginsts")
	public String getOtp(@RequestParam ("username") String Username) {
		String demo="+91"+Username;
		String otp=userService.generateOtp(Username);
		otp1=otp;
	    otpservice.sendOtp(demo,otp);
	    System.out.println(otp);
		return "success";
	}
	@GetMapping("/verification")
	public String checkOtp(@RequestParam ("Otp") String OTP) {
		if(OTP.equals(otp1) ) {
			return "verifide";
		}else {
			return "Fail";
		}
	}
	
}
