package com.laletin.logic;

import org.jsoup.nodes.Element;

/*
    Created by Dmitriy Laletin 
    on 1:14 PM 5/29/2018 May 2018
*/
public class Result {
    private Element element;
    private int frequency;

    public Result(Element element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    public Element getElement() {
        return element;
    }

    public int getFrequency() {
        return frequency;
    }
}
