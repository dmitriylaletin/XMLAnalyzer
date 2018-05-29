package com.laletin.logic;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Created by Dmitriy Laletin 
    on 2:24 PM 5/29/2018 May 2018
*/
public class AttributeLogic implements Logic {

    private Map<String, String> getAllAttributes(Element element){
        return element
                .attributes()
                .asList()
                .stream()
                .collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
    }
    @Override
    public int elementLocator(Element firstElement, Element secondElement) {
        Map<String, String> firstElementAttributes = getAllAttributes(firstElement);
        Map<String, String> secondElementAttributes = getAllAttributes(secondElement);

        return firstElementAttributes
                .keySet()
                .stream()
                .filter(secondElementAttributes::containsKey)
                .mapToInt(key -> {
                    if (firstElementAttributes.get(key).equals(secondElementAttributes.get(key))) {
                        return 1;
                    }
                    return 0;
                })
                .sum();
    }
}
