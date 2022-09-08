package com.nagarro.training.advanceJavaAssignment4.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.training.advanceJavaAssignment4.dao.LoginDao;
import com.nagarro.training.advanceJavaAssignment4.dao.TshirtDao;
import com.nagarro.training.advanceJavaAssignment4.model.LoginModel;

@Controller
public class LoginController {

	@Autowired
	private LoginDao ld;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("ver", new LoginModel());
		return "login";
	}
	

	@RequestMapping(value = "home", method = RequestMethod.POST)
	public String verify(@ModelAttribute("ver") @Valid LoginModel login, BindingResult result, Model model) {


		if (ld.validator(login)) {
//			TshirtDao.truncateTshirt();
			Track.fetchData();
			return "home";
		}
		else {
			model.addAttribute("msg","UserName or Password is Incorrect");
			System.out.println("login failed....");

			return "login";
		}
	}

}
