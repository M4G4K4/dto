package com.korber.dto.scripts.csv;

import com.korber.dto.scripts.csv.service.ImportService;

import java.io.FileNotFoundException;

public class ImportCsv {

    private static final ImportService service = new ImportService();

    public static void main(String[] args) throws FileNotFoundException {
        service.readCsv(args);
    }

}
