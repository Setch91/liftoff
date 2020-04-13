package org.launchcode.Travelwebsite.controllers;

import org.launchcode.Travelwebsite.models.Search;
import org.launchcode.Travelwebsite.models.State;
import org.launchcode.Travelwebsite.models.data.CityRepo;
import org.launchcode.Travelwebsite.models.data.EventRepo;
import org.launchcode.Travelwebsite.models.data.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

import static org.launchcode.Travelwebsite.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {
    @Autowired
    private StateRepo stateRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private CityRepo cityRepo;


    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("column", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<State> states;
        if (searchTerm.toLowerCase().equals("all")){
            states = stateRepo.findAll();
        } else {
            states = Search.findByColumnAndValue(searchType, searchTerm, stateRepo.findAll());
        }
        model.addAttribute("column", columnChoices);
        model.addAttribute("title", "States with " + columnChoices);
        model.addAttribute("states", states);
        model.addAttribute("city", cityRepo.findAll());
        model.addAttribute("event", eventRepo.findAll());

        return "search";
    }
}
