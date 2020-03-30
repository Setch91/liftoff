package org.launchcode.Travelwebsite.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends AbstractEntity {

    @ManyToOne
    private State states;
    @OneToMany
    private Event events;

    @NotNull
    private String pride;
    @NotNull
    private String bars;
    @NotNull
    private String destinations;

    public City() {
    }

    public Event getEvents(){return events;}
    public State getStates(){return states;}
}
