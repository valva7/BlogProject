package com.project.song;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.song.service.serviceImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class signUpController {
	
	@Autowired
	serviceImp serviceImp;
	
	// ȸ������ ȭ��
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String singUp(Locale locale, Model model) {
		
		
		return "signUp";
	}
}
