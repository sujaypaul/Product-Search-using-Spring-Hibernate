package com.nagarro.training.advanceJavaAssignment4.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.advanceJavaAssignment4.model.Tshirt;
import com.nagarro.training.advanceJavaAssignment4.model.TshirtSearchIp;

@Controller
public class SearchController {

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchTshirt(@ModelAttribute("ser") @Valid TshirtSearchIp inp, BindingResult result, Model model) throws FileNotFoundException {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("\nsearch Parameters :___________");
		System.out.println(inp.getColor());
		System.out.println(inp.getSize());
		System.out.println(inp.getGender());
		System.out.println(inp.getOutputPreference());

		List<Tshirt> list = TshirtSearchOp.getMatchingTshirts(inp);

		System.out.println("\n"+list.size()+" results found");

		if (list.size() == 0) {
			model.addAttribute("msg", "0 results found");
			System.out.println("nothing found");
			return "home";
		}
		
		model.addAttribute("msg", list.size()+" results found");
		for (Tshirt t : list) {
			System.out.println(t.getId() + " found with matching description");
		}
		model.addAttribute("list",list);
		return "home";

	}

}
