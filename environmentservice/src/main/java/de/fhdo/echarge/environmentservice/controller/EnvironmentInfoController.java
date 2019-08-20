package de.fhdo.echarge.environmentservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.fhdo.echarge.environmentservice.entity.EnvironmentInfo;
import de.fhdo.echarge.environmentservice.repository.EnvironmentInfoRepository;
/**
 * Neue Controller-Bean für das Frontend des Environment-Service erstellt,
 * damit Umweltinformationen erfasst werden können.
 * @author kahriman
 *
 */
@Controller
@RequestMapping("/environmentInfos/")
public class EnvironmentInfoController {

	private final EnvironmentInfoRepository environmentInfoRepository;

	@Autowired
	public EnvironmentInfoController (EnvironmentInfoRepository environmentInfoRepository) {
		this.environmentInfoRepository = environmentInfoRepository;
	}

    @GetMapping("/register")
    public String showSignUpForm(EnvironmentInfo environmentInfo) {
        return "add-environmentInfo";
    }


    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("environmentInfos", environmentInfoRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/createEnvironmentInfo")
    public String createEnvironmentInfo(@Valid EnvironmentInfo environmentInfo, BindingResult result, Model model) {

    	if(result.hasErrors()) {
        	return "add-environmentInfo";
        }

        environmentInfoRepository.save(environmentInfo);
        model.addAttribute("environmentInfos", environmentInfoRepository.findAll());
        return "redirect:list";
    }


    @PostMapping(value = "updateEnvironmentInfo/{id}")
    public String updateEnvironmentInfo(@PathVariable("id") String id, @Valid EnvironmentInfo environmentInfo, BindingResult result,
            Model model) {
    	if(result.hasErrors()) {
    		environmentInfo.setId(id);
    		return "update-environmentInfo";
    	}

    	environmentInfoRepository.save(environmentInfo);
    	model.addAttribute("environmentInfos", environmentInfoRepository.findAll());
    	return "index";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteEnvironmentInfo(@PathVariable("id") String id, Model model) {
        if(environmentInfoRepository.existsById(id)) {
        	environmentInfoRepository.delete(environmentInfoRepository.findById(id).get());
        }
        model.addAttribute("environmentInfos", environmentInfoRepository.findAll());
        return "index";
    }

}
