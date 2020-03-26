package org.launchcode.Travelwebsite.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class State extends AbstractEntity {

    @OneToMany
    @JoinColumn
    private List<City> cities = new ArrayList<>();

    @OneToMany
    @JoinColumn
    private List<Event> events = new ArrayList<>();

    public State() {
    }

    private List<Event> getEvents() { return events; }

    private List<City> getCities() { return cities; }
}
