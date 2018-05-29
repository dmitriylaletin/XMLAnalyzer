package com.laletin.analyzer;

import com.laletin.logic.AttributeLogic;
import com.laletin.logic.IdLogic;
import com.laletin.logic.Result;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Created by Dmitriy Laletin 
    on 2:10 PM 5/29/2018 May 2018
*/
public class AnalyzeXML {

    private final Element originalElement;
    private final Elements undefiniedElements;

    public AnalyzeXML(Element originalElement, Elements undefiniedElements) {
        this.originalElement = originalElement;
        this.undefiniedElements = undefiniedElements;
    }

    public Result findRightElement(){
        List<Result> resultList = new ArrayList<>();
        for (Element element : undefiniedElements) {
            int frequencyCounter = Arrays.asList(new AttributeLogic(), new IdLogic())
                    .stream()
                    .mapToInt(logic -> logic.elementLocator(originalElement, element))
                    .sum();
            resultList.add(new Result(element, frequencyCounter));
        }
        resultList.sort(Comparator.comparing(Result::getFrequency).reversed());
        return resultList.get(0);
    }
}
