package paulo.parking.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import paulo.parking.demo.service.Crud;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    Crud parkingService;

    public DemoApplication(Crud parkingService) {
        this.parkingService = parkingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Boolean isTrue = true;
        Scanner in = new Scanner(System.in);

        while (isTrue) {
            System.out.println("Digite uma opção: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar parking");
            System.out.println("2 - Deletar parking");
            System.out.println("3 - List parking");
            System.out.println("4 - Update parking");
            System.out.println("5 - Buscar por id");

            System.out.print("OP: ");
            int op = in.nextInt();

            switch (op) {
                case 0:
                    isTrue = false;
                    break;
                case 1:
                    parkingService.saveParking(in);
                    break;
                case 2:
                    parkingService.deleteParking(in);
                    break;
                case 3:
                    parkingService.listParking();
                    break;
                case 4:
                    parkingService.updateParking(in);
                    break;
                case 5:
                    parkingService.findById(in);
                    break;
                default:
                    System.out.println("Op invalida.");
                    break;

            }
        }
    }


}

