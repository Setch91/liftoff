package org.launchcode.Travelwebsite.controllers;

import org.launchcode.Travelwebsite.models.City;
import org.launchcode.Travelwebsite.models.data.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityRepo cityRepo;

    @GetMapping("add")
    public String displayAddCityForm(Model model){
        model.addAttribute(new City());
        return "city/add";
    }

    @PostMapping("add")
    public String processAddCityForm(@ModelAttribute @Valid City newCity, Errors errors){
        if (errors.hasErrors()){
            return "city/add";
        }

        cityRepo.save(newCity);

        return "redirect:view/"+newCity.getId();
    }

    @GetMapping("view/{cityId}")
    public String displayViewCity(Model model, @PathVariable int cityId){
        Optional optCity = cityRepo.findById(cityId);
        if (optCity.isPresent()){
            City city = (City) optCity.get();
            model.addAttribute("city", city);
            return "city/view";
        } else return "redirect../";

    }


}
