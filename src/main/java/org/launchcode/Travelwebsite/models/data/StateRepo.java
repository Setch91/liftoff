package org.launchcode.Travelwebsite.models.data;

import org.launchcode.Travelwebsite.models.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends CrudRepository<State, Integer> {
}
