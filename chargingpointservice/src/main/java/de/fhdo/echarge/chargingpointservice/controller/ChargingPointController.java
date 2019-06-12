package de.fhdo.echarge.chargingpointservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.fhdo.echarge.chargingpointservice.entity.ChargingPoint;
import de.fhdo.echarge.chargingpointservice.repository.ChargingPointRepository;

@Controller
@RequestMapping("/chargingPoints/")
public class ChargingPointController {

	private final ChargingPointRepository chargingPointRepository;

	@Autowired
	public ChargingPointController (ChargingPointRepository chargingPointRepository) {
		this.chargingPointRepository = chargingPointRepository;
	}

    @GetMapping("/register")
    public String showSignUpForm(ChargingPoint chargingPoint) {
        return "add-chargingPoint";
    }


    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("chargingPoints", chargingPointRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/createChargingPoint")
    public String createChargingPoint(@Valid ChargingPoint chargingPoint, BindingResult result, Model model) {

    	if(result.hasErrors()) {
        	return "add-chargingPoint";
        }

        chargingPointRepository.save(chargingPoint);
        model.addAttribute("chargingPoints", chargingPointRepository.findAll());
        return "redirect:list";
    }


    @PostMapping(value = "updateChargingPoint/{id}")
    public String updateChargingPoint(@PathVariable("id") String id, @Valid ChargingPoint chargingPoint, BindingResult result,
            Model model) {
    	if(result.hasErrors()) {
    		chargingPoint.setId(id);
    		return "update-chargingPoint";
    	}

    	chargingPointRepository.save(chargingPoint);
    	model.addAttribute("chargingPoints", chargingPointRepository.findAll());
    	return "index";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteChargingPoint(@PathVariable("id") String id, Model model) {
        if(chargingPointRepository.existsById(id)) {
        	chargingPointRepository.delete(chargingPointRepository.findById(id).get());
        }
        model.addAttribute("chargingPoints", chargingPointRepository.findAll());
        return "index";
    }

}
