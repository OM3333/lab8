package com.company;

import java.io.FileWriter;
import java.util.ArrayList;

public class SvgScene {
    private ArrayList<Polygon> polygons = new ArrayList<>();
    private int height = 0, width = 0;

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
        Point maxPoint = polygon.getMaxCords();
        height = (int)Math.max(this.height, maxPoint.y);
        width = (int)Math.max(this.width, maxPoint.x);
    }


        public void save(String file){
            try {

                // attach a file to FileWriter
                FileWriter fileWriter= new FileWriter(file);
                String str = "<html>\n" + "<body>";
                str += "<svg width=\"" + width + "\" height=\"" + height +"\">";
              for(Polygon pol : this.polygons){
                  str += pol.toSvg();
              }
                str += "</svg>\n" + "\n" + "</body>\n" + "</html>";

              fileWriter.write(str);
                fileWriter.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        }
}
