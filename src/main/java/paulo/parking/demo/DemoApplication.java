package paulo.parking.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import paulo.parking.demo.service.CrudParking;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    CrudParking parkingService;

    public DemoApplication(CrudParking parkingService){
        this.parkingService = parkingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Boolean isTrue = true;
        Scanner in = new Scanner(System.in);

        while(isTrue){
            System.out.println("Digite uma opção: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar parking");
            System.out.print("OP: ");
            int op = in.nextInt();

            if(op == 0){
                isTrue = false;
            }
            if (op ==1){
                parkingService.saveParking(in);
            }

        }
    }
}

