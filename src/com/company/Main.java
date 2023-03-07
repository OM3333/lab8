package com.company;

import java.util.ArrayList;
import java.util.Locale;


public class Main {
    public static final Point test = new Point(2,3);

    public static void main(String[] args) {

        ArrayList<Shape> test = new ArrayList<>();
        test.add(new Polygon(2, new Style(null, null, null)));
        test.add(new Segment(new Point(1,2), new Point(2,3)));

        String str = "";
        for(Shape shape : test){
            str += shape.toSvg();
        }
    }
}
