package paulo.parking.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paulo.parking.demo.entities.Parking;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {


}
