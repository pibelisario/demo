package paulo.parking.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import paulo.parking.demo.entities.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
