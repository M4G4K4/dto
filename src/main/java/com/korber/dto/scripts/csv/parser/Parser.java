package com.korber.dto.scripts.csv.parser;

import java.io.FileNotFoundException;

public interface Parser {

    void parse(String filePath) throws FileNotFoundException;

    void persist();
}
