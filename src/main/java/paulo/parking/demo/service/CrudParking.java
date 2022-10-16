package paulo.parking.demo.service;

import org.springframework.stereotype.Service;
import paulo.parking.demo.entities.Parking;
import paulo.parking.demo.repositories.ParkingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

@Service
public class CrudParking {

    private ParkingRepository repositoryParking;

    public CrudParking(ParkingRepository repositoryParking) {
        this.repositoryParking = repositoryParking;
    }

    public void saveParking(Scanner in){
        System.out.println("Cadastro de nova Parking: ");
        System.out.print("Parking number: ");
        String parkingNumber = in.next();
        System.out.print("Plate car: ");
        String plateCar = in.next();
        System.out.print("Brand car: ");
        String brandCar = in.next();
        System.out.print("Model car: ");
        String modelCar = in.next();
        System.out.print("Color car: ");
        String colorCar = in.next();
        System.out.print("Resposible name: ");
        String resposibleName = in.next();
        System.out.print("Apartment: ");
        String apartment = in.next();
        System.out.print("Block: ");
        String block = in.next();

        Parking parking = new Parking(parkingNumber, plateCar, brandCar, modelCar, colorCar, LocalDateTime.now(),resposibleName, apartment, block);

        repositoryParking.save(parking);
        System.out.println("Save with sucess.");
    }
}
