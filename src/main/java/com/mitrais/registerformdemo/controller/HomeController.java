package com.mitrais.registerformdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mitrais.registerformdemo.model.User;
import com.mitrais.registerformdemo.service.UserService;
import com.mitrais.registerformdemo.util.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "redirect:/registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult,
			Model model) {
		boolean res = true;
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			res = false;
		}
		try {
			userService.save(userForm);
		} catch (Exception e) {
			res = false;
			e.printStackTrace();
		} finally {
			model.addAttribute("res", res);
			return "registration";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

}
