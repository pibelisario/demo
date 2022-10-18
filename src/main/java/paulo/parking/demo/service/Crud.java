package paulo.parking.demo.service;

import org.springframework.stereotype.Service;
import paulo.parking.demo.entities.Car;
import paulo.parking.demo.entities.Parking;
import paulo.parking.demo.repositories.CarRepository;
import paulo.parking.demo.repositories.ParkingRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Crud {

    private ParkingRepository repositoryParking;
    private CarRepository repositoryCar;
    private Car car = null;
    boolean control = true;
    Long id = null;

    public Crud(ParkingRepository repositoryParking, CarRepository repositoryCar) {
        this.repositoryParking = repositoryParking;
        this.repositoryCar = repositoryCar;
    }

    public void saveParking(Scanner in) {

        control = true;

        Parking parking = initialInfo(in);
        repositoryCar.save(car);
        repositoryParking.save(parking);
        System.out.println("Success.");

    }


    public void deleteParking(Scanner in) {
        System.out.print("Id parking: ");
        Long id = in.nextLong();

        Optional<Parking> optional = repositoryParking.findById(id);

        if (optional.isPresent()) {
            repositoryParking.delete(optional.get());
            repositoryCar.delete(optional.get().getCar());
            System.out.println("Deleted with success.");
        } else {
            System.out.println("Parking not found.");
        }
    }

    public void listParking() {
        Iterable<Parking> listParking = repositoryParking.findAll();

        listParking.forEach(System.out::println);

    }

    public void updateParking(Scanner in) {

        System.out.print("Id to update: ");
        id = in.nextLong();

        Optional<Parking> pk = repositoryParking.findById(id);

        if (pk.isPresent()) {
            saveParking(in);
        } else {
            System.out.println("Id not found.");
        }


    }

    public Parking initialInfo(Scanner in) {
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
        System.out.print("Responsible name: ");
        String resposibleName = in.next();
        System.out.print("Apartment: ");
        String apartment = in.next();
        System.out.print("Block: ");
        String block = in.next();

        if (!control()) {
            car = new Car(plateCar, brandCar, modelCar, colorCar);
            Parking pk = new Parking(parkingNumber, LocalDateTime.now(), resposibleName, apartment, block, car);
            return pk;
        } else {
            Optional<Parking> op = repositoryParking.findById(id);
            Parking pk = op.get();
            pk.setParkingNumber(parkingNumber);
            pk.getCar().setPlateCar(plateCar);
            pk.getCar().setBrandCar(brandCar);
            pk.getCar().setModelCar(modelCar);
            pk.getCar().setColorCar(colorCar);
            pk.setResponsibleName(resposibleName);
            pk.setApartment(apartment);
            pk.setBlock(block);
            return pk;
        }
    }

    public boolean control() {
        Optional<Parking> op = null;
        if (id != null) {
            op = repositoryParking.findById(id);
            if (op.isPresent()) {
                return true;
            }
        }

        return false;
    }


    public void findById(Scanner in) {
        System.out.print("Id to find: ");
        Long id = in.nextLong();
        Optional<Parking> pk = repositoryParking.findById(id);
        if (pk.isPresent()) {
            System.out.println(pk.get());
        } else {
            System.out.println("Id not found");
        }
    }
}
