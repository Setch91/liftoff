package org.launchcode.Travelwebsite.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Event extends AbstractEntity {

    @ManyToOne
    private City city;

    public Event() {
    }

    public City getCity(){return city;}
}
