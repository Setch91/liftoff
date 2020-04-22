package org.launchcode.Travelwebsite.controllers;

import org.launchcode.Travelwebsite.models.City;
import org.launchcode.Travelwebsite.models.Event;
import org.launchcode.Travelwebsite.models.State;
import org.launchcode.Travelwebsite.models.data.CityRepo;
import org.launchcode.Travelwebsite.models.data.EventRepo;
import org.launchcode.Travelwebsite.models.data.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private CityRepo cityRepo;

    @GetMapping("add")
    public String displayAddStateForm(Model model){
        model.addAttribute("title", "Add State");
        model.addAttribute("cities",cityRepo.findAll());
        model.addAttribute("events", eventRepo.findAll());
        model.addAttribute(new State());
        return "add";
    }

    @PostMapping("add")
    public String processAddStateForm(@ModelAttribute @Valid State newState, Errors errors, Model model, @RequestParam List<Integer> cities, @RequestParam List<Integer> events){

        if (errors.hasErrors()){
            model.addAttribute("title", "Add State");
            return "add";
        }

        List<City> cityObjs = (List<City>) cityRepo.findAllById(cities);
        List<Event> eventObjs = (List<Event>) eventRepo.findAllById(events);
        newState.setCities(cityObjs);
        newState.setEvents(eventObjs);
        stateRepo.save(newState);
        return "redirect:view/"+newState.getId();
    }

    @GetMapping("view/{stateId}")
    public String displayViewJob(Model model, @PathVariable int stateId){
        Optional optState = stateRepo.findById(stateId);
        if (optState.isPresent()){
            State state = (State) optState.get();
            model.addAttribute("state", state);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}
