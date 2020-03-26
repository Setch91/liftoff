package org.launchcode.Travelwebsite.models.data;

import org.launchcode.Travelwebsite.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository<City, Integer> {
}
