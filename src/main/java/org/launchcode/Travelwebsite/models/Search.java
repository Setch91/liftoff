package org.launchcode.Travelwebsite.models;

import java.util.ArrayList;

public class Search {



    public static ArrayList<State> findByValue(String value, Iterable<State> allStates){

        ArrayList<State> results = new ArrayList<>();


        for (State state : allStates){
            if (state.getName().toLowerCase().contains(value.toLowerCase())){
                results.add(state);
            } else if (state.getCities().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(state);
            } else if (state.getEvents().toString().toLowerCase().contains(value.toLowerCase())){
                results.add(state);
            } else if (state.toString().toLowerCase().contains(value.toLowerCase())){
                results.add(state);
            }
        } return results;
    }
}
