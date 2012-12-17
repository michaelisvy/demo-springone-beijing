package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String showCreationForm(Model model){
		model.addAttribute("user", new User());
		return "userFormSimple";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String processCreationForm(Model model, @Valid User user, BindingResult result ){
		if(result.hasErrors()) {
			return "userFormSimple";
		} 
		else {
			return "success";
		}
	}
	
	@RequestMapping(value="/userSearch",method=RequestMethod.GET)
	public String showSearchForm(Model model){
		model.addAttribute("user", new User());
		return "userSearch";
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	public String showUserList(Model model){
		List<User> userList = new ArrayList<User>();
		
		for (int i = 1; i < 10; i++) {
			userList.add(new User("Mickey "+i, "Mouse"));
			userList.add(new User("Minnie"+i, "Mouse"));
			userList.add(new User("Donald"+i, "Duck"));
			userList.add(new User("Daisy"+i, "Duck"));
		}
		model.addAttribute("userList", userList);			
		return "userList";
	}
	
	@RequestMapping(value="/userBootstrap",method=RequestMethod.GET)
	public String showCreationFormBootstrap(Model model){
		model.addAttribute("user", new User());
		return "userFormBootstrap";
	}
	
	@RequestMapping(value="/userBootstrap",method=RequestMethod.POST)
	public String processCreationFormBootstrap(Model model, @Valid User user, BindingResult result ){
		if(result.hasErrors()) {
			return "userFormBootstrap";
		} 
		else {
			return "success";
		}
	}
	
	
	@RequestMapping(value="/userCustomTag",method=RequestMethod.GET)
	public String showCreationFormCustomTag(Model model){
		model.addAttribute("user", new User());
		return "userFormCustomTag";
	}
	
	@RequestMapping(value="/userCustomTag",method=RequestMethod.POST)
	public String processCreationFormCustomTag(Model model, @Valid User user, BindingResult result ){
		if(result.hasErrors()) {
			return "userFormCustomTag";
		} 
		else {
			return "success";
		}
	}

	
}
