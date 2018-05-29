package com.laletin;

import com.laletin.analyzer.AnalyzeXML;
import com.laletin.logic.Result;
import com.laletin.parser.FileParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/*
    Created by Dmitriy Laletin 
    on 1:10 PM 5/29/2018 May 2018
*/
public class AppStart {


    public static void main(String[] args) {
        File firstHtml = new File(args[0]);
        File secondHtml = new File(args[1]);

        FileParser fileParser = new FileParser();

        Document firstDocument = fileParser.parseFile(firstHtml);
        Document secondDocument = fileParser.parseFile(secondHtml);

        Element sourceElement = firstDocument.body().getElementById("make-everything-ok-button");
        Elements tagElements =  getElementByTag(secondDocument, sourceElement.tagName());

        AnalyzeXML analyzeXML = new AnalyzeXML(sourceElement, tagElements);
        Result result = analyzeXML.findRightElement();

        System.out.println("Xpath for specific element is: ".concat(getElelementPath(result.getElement())));
        System.out.println("Element frequency matching rate is: ".concat(Integer.toString(result.getFrequency())));
    }

    private static Elements getElementByTag(Document document, String tag) {
        return document.body().getElementsByTag(tag);
    }

    private static String getElelementPath(Element element){
        List<String> pathList = element.parents()
                .stream()
                .map(AppStart :: pathFormatter)
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = pathList.size() - 1; i >= 0; i --){
            stringBuilder.append(pathList.get(i)).append(" > ");
        }
        stringBuilder.append(pathFormatter(element));
        return stringBuilder.toString();
    }

    private static String pathFormatter(Element element) {
        return String.format("%s[%s]", element.tagName(), element.elementSiblingIndex());
    }
}
