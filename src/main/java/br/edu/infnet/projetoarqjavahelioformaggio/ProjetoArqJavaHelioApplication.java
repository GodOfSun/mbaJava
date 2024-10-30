package br.edu.infnet.projetoarqjavahelioformaggio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoArqJavaHelioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoArqJavaHelioApplication.class, args);
    }

}
