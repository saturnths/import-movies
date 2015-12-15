import app.importmovies.model.Movie;
import app.importmovies.service.ParserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("test")
public class ParserServiceTest {

    @InjectMocks
    private ParserService parserService;

    @Test
    public void firstRowMovieNameTest() {
        String testFile = getClass().getResource("/sample-movies.csv").getPath();
        parserService.setPath(testFile);
        List<Movie> movies = parserService.getRows();

        String firstRowMovieName = movies.get(0).getName();
        assertTrue(firstRowMovieName.equals("Test Movie 1"));
    }
}
