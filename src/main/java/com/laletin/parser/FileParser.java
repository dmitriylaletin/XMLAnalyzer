package com.laletin.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;

/*
    Created by Dmitriy Laletin 
    on 1:05 PM 5/29/2018 May 2018
*/
public class FileParser {

    public Document parseFile (File file){
        try {
            return Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(String.format("Source file '%s' cannot be parsed", file.getName()));
        }
    }
}
