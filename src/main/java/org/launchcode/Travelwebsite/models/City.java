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
    @JoinColumn
    private List<Event> events = new ArrayList<>();

    @NotNull
    private String pride;
    @NotNull
    private String bars;
    @NotNull
    private String destinations;

    public City() {
    }

    public List<Event> getEvents(){return events;}
    public State getStates(){return states;}

    public String getPride() {
        return pride;
    }

    public void setPride(String pride) {
        this.pride = pride;
    }

    public String getBars() {
        return bars;
    }

    public void setBars(String bars) {
        this.bars = bars;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }
}
