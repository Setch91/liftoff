package org.launchcode.Travelwebsite.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City extends AbstractEntity {

    @ManyToOne
    private State states;

    public City() {
    }

    public State getStates(){return states;}
}
