package org.launchcode.Travelwebsite.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Event extends AbstractEntity {

    @ManyToOne
    private City city;
    @ManyToOne
    private State state;

    @NotNull
    private String date;

    public Event() {
    }

    public City getCity(){return city;}

    public State getState() {
        return state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
