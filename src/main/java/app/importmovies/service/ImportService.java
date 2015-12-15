package app.importmovies.service;

import app.importmovies.model.Movie;
import app.importmovies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;


@Service
public class ImportService {

    private static final Logger log = LoggerFactory.getLogger(ImportService.class);

    private static MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        ImportService.movieRepository = movieRepository;
    }

    public static void importMovies(String filepath) {

        ParserService.setPath(filepath);

        List<Movie> movies = ParserService.getRows();

        for (Movie movie : movies) {
            movieRepository.save(movie);
        }

        System.out.println(movies.size() + " movies were successfully imported.");

        // show all items
        Iterable<Movie> im = movieRepository.findAll();

        for (Movie m : im) {
            System.out.println("Retrieved movie " + m.getName()  + " with description " + m.getDescription() + " and date " + m.getDate() + " from repository");
        }

        System.exit(0);
    }

}
