package org.launchcode.Travelwebsite.controllers;

import org.launchcode.Travelwebsite.models.Search;
import org.launchcode.Travelwebsite.models.State;
import org.launchcode.Travelwebsite.models.data.CityRepo;
import org.launchcode.Travelwebsite.models.data.EventRepo;
import org.launchcode.Travelwebsite.models.data.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private EventRepo eventRepo;

    static HashMap<String,String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("City","city");
        columnChoices.put("Event","event");

    }

    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("cities",cityRepo.findAll());
        model.addAttribute("events",eventRepo.findAll());

        return "list";

    }

    @RequestMapping(value = "states")
    public String listStatesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value){
        Iterable<State> states;
        if (column.toLowerCase().equals("all")){
            states = stateRepo.findAll();
            model.addAttribute("title", "All States");
        } else {
            states = Search.findByColumnAndValue(column, value, stateRepo.findAll());
            model.addAttribute("title", "States with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("states", states);

        return "list-states";
    }
}
