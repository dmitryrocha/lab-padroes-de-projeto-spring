package one.digitalinnovation.labpadroesdeprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LabPadroesDeProjetoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabPadroesDeProjetoSpringApplication.class, args);
    }

}
