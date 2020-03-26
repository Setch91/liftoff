package org.launchcode.Travelwebsite.models.data;

import org.launchcode.Travelwebsite.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends CrudRepository<Event, Integer> {
}
