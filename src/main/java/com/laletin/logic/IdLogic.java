package com.laletin.logic;

import org.jsoup.nodes.Element;

/*
    Created by Dmitriy Laletin 
    on 2:21 PM 5/29/2018 May 2018
*/
public class IdLogic implements Logic {
    @Override
    public int elementLocator(Element firstElement, Element secondElement) {
        if (firstElement.hasText() && secondElement.hasText()
                &&firstElement.text().equals(secondElement.text()))
            return 1;
        else
            return 0;
    }
}
