package app.importmovies.service;

import com.opencsv.CSVReader;
import app.importmovies.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {

    private static final Logger log = LoggerFactory.getLogger(ParserService.class);

    private static String path;

    public static List<Movie> getRows() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path), ',', '\'', 1);
        } catch (FileNotFoundException e) {
            System.out.println("Error: could not open the file " + path);
            log.error("Error opening file", e);
            System.exit(-1);
        }
        String [] line;

        List<Movie> rows = new ArrayList<Movie>();

        try {
            while ((line = reader.readNext()) != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

                try {
                    rows.add(new Movie(line[0], line[1], sdf.parse(line[2])));
                } catch (ParseException e) {
                    log.error("ParseException when trying to parse a date", e);
                }
            }
        } catch (IOException e) {
            log.error("IOException when trying to open the spreadsheet", e);
        }

        return rows;
    }

    public static void setPath(String path) {
        ParserService.path = path;
    }

    public static String getPath() {
        return ParserService.path;
    }
}
