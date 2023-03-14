package com.company;

import java.awt.*;
import java.util.ArrayList;

public class SolidFilledPolygon extends Polygon{
    private String color;
    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }
    @Override
    public String toSvg(String paremeters) {
        String fill = "fill=\""+this.color+"\"" + paremeters;
        return super.toSvg(fill);
    }
}
