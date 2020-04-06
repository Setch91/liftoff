package org.launchcode.Travelwebsite.models;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.ArrayList;

public class Search {

    public static ArrayList<State> findByColumnAndValue(String column, String value, Iterable<State> allStates){

        ArrayList<State> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<State>) allStates;
        }

        if (column.equals("all")){
            results = findByValue(value, allStates);
            return results;
        }

        for (State state : allStates){
            String theValue = getFieldValue(state, column);
            if (theValue != null && theValue.toLowerCase().contains(value.toLowerCase())){
                results.add(state);
            }
        }
        return results;
    }

    public static String getFieldValue(State state, String fieldName){
        String value;
        if (fieldName.equals("name")){
            value = state.getName();
        } else if (fieldName.equals("city")) {
            value = state.getCities().toString();
        } else value = state.getEvents().toString();

        return value;

    }

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
