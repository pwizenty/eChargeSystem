package de.fhdo.echarge.usermanagementservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.fhdo.echarge.usermanagementservice.entity.User;
import de.fhdo.echarge.usermanagementservice.repository.UserRepository;

@Controller
@RequestMapping("/users/")
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController (UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @GetMapping("/register")
    public String showSignUpForm(User user) {
        return "add-user";
    }


    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:list";
    }

    @PostMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") String id, @Valid User user, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        if(userRepository.existsById(id)) {
        	userRepository.delete(userRepository.findById(id).get());
        }
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }



}
