package org.launchcode.Travelwebsite.controllers;

import org.launchcode.Travelwebsite.models.Event;
import org.launchcode.Travelwebsite.models.data.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepo eventRepo;

    @GetMapping("add")
    public String displayAddEventForm(Model model){
        model.addAttribute(new Event());
        return "events/add";
    }

    @PostMapping("add")
    public String processAddCityForm(@ModelAttribute @Valid Event newEvent, Errors errors){
        if (errors.hasErrors()){
            return "events/add";
        }

        eventRepo.save(newEvent);

        return "redirect:view/"+newEvent.getId();
    }

    @GetMapping("view/{eventId}")
    public String displayViewEvent(Model model, @PathVariable int eventId){
        Optional optEvent = eventRepo.findById(eventId);
        if (optEvent.isPresent()){
            Event event = (Event) optEvent.get();
            model.addAttribute("event", event);
            return "events/view";
        } else return "redirect../";

    }


}
