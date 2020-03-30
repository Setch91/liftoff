package org.launchcode.Travelwebsite.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(min = 1, max = 5)
    private Integer rank;

    public State() {
    }

    private List<Event> getEvents() { return events; }

    private List<City> getCities() { return cities; }
}
