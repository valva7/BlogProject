package com.project.song.home.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.song.home.serviceImpl.serviceImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	serviceImp serviceImp;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String str = serviceImp.oneTest();
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		System.out.println(str);
		System.out.println(list.toString());
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("list", list );
		model.addAttribute("str", str );
		
		return "login";
	}
	
	// ȸ������ ȭ��
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String singUp(Locale locale, Model model) {
		
		return "signUp";
	}
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		System.out.println(list.toString());
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("list", list );
		
		return "main/main";
	}
	
}