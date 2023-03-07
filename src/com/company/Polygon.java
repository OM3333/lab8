package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Polygon extends Shape {
    private Point[] arr;
    private Style style;

    public Polygon(int count, Style style) {
        arr = new Point[count];
        this.style = style;
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" style = \"%s\" />", pointsString, this.style.toSvg());
    }

    public Point getMaxCords() {
        Point maxPoint = new Point(0,0);

        for(Point p : this.arr) {
            if(p.x > maxPoint.x) {
                maxPoint.x = p.x;
            }
            if(p.y > maxPoint.y) {
                maxPoint.y = p.y;
            }
        }

        return maxPoint;
    }

}
