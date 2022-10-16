package paulo.parking.demo.entities;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "TB_PARKING_STOP")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String plateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;

    public Parking(){

    }

    public Parking(String parkingNumber, String plateCar, String brandCar, String modelCar, String colorCar, LocalDateTime registrationDate, String responsibleName, String apartment, String block) {
        this.parkingNumber = parkingNumber;
        this.plateCar = plateCar;
        this.brandCar = brandCar;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.registrationDate = registrationDate;
        this.responsibleName = responsibleName;
        this.apartment = apartment;
        this.block = block;
    }

    public Integer getId() {
        return id;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public String getPlateCar() {
        return plateCar;
    }

    public void setPlateCar(String plateCar) {
        this.plateCar = plateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", parkingNumber='" + parkingNumber + '\'' +
                ", plateCar='" + plateCar + '\'' +
                ", brandCar='" + brandCar + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", colorCar='" + colorCar + '\'' +
                ", registrationDate=" + registrationDate +
                ", responsibleName='" + responsibleName + '\'' +
                ", apartment='" + apartment + '\'' +
                ", block='" + block + '\'' +
                '}';
    }
}
