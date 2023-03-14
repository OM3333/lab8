package com.company;

import java.util.ArrayList;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120, 60), new Vec2(270, 280), new Vec2(240, 320), new Vec2(110, 80)});

        Shape ellipse = new Ellipse(new Vec2(2, 3), 10, 20);
        poly = new SolidFilledShapeDecorator(poly, "red");
        poly = new StrokeShapeDecorator(poly, "green", 24);
        ellipse = new SolidFilledShapeDecorator(ellipse, "blue");
        ellipse = new StrokeShapeDecorator(ellipse, "green", 24);


        //      SvgScene scene=new SvgScene();
//        scene.addShape(poly);
//        scene.saveHtml("scene.html");
    }
}
