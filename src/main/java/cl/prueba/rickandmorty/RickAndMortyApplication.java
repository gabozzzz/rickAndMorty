package cl.prueba.rickandmorty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type Rick and morty application.
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "cl.prueba.rickandmorty")
public class RickAndMortyApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RickAndMortyApplication.class, args);
    }

}
