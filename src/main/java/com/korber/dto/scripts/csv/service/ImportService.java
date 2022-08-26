package com.korber.dto.scripts.csv.service;

import com.korber.dto.scripts.csv.parser.Parser;
import com.korber.dto.scripts.csv.parser.TripParser;
import com.korber.dto.scripts.csv.parser.ZoneParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;

public class ImportService {

    @Autowired
    private TripParser tripParser;

    @Autowired
    private ZoneParser zoneParser;

    public void readCsv(final String[] args) throws FileNotFoundException {
        verifications(args);

        final String fileName = args[0].replace("/", "");
        final String filePath = "/files/" + fileName;

        final Parser parser = getParser(fileName);

        parser.parse(filePath);
        parser.persist();
    }

    private Parser getParser(final String fileName) {
        final Parser parser;

        if (fileName.contains("yellow") || fileName.contains("green")) {
            parser = tripParser;
        } else {
            parser = zoneParser;
        }

        return parser;
    }

    private void verifications(final String[] args){
        if(args.length == 0){
            System.out.println("File must be provided");
            System.exit(1);
        }

        if(args.length > 1){
            System.out.println("One File at time");
            System.exit(1);
        }
    }

}
