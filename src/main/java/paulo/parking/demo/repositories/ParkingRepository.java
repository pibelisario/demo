package paulo.parking.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import paulo.parking.demo.entities.Parking;

import java.time.LocalDateTime;
import java.util.Scanner;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {



}
