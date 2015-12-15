package app.importmovies.service;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandsService {
    private static final Logger log = LoggerFactory.getLogger(CommandsService.class);

    public static String getFilePath(String[] args) {
        Options options = new Options();
        options.addOption("c", true, "Path of the input spreadsheet.");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            log.error("ParseException:", e);
        }

        return cmd.getOptionValue("c");
    }
}
