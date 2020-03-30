package org.launchcode.Travelwebsite.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Event extends AbstractEntity {

    @ManyToOne
    private City city;
    @NotNull
    private String date;

    public Event() {
    }

    public City getCity(){return city;}
}
