package app.importmovies;

import app.importmovies.service.CommandsService;
import app.importmovies.service.ImportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("app.importmovies")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String filepath = CommandsService.getFilePath(args);
        ImportService.importMovies(filepath);
    }
}