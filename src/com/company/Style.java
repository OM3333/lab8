package com.company;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeWidth;

    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg(){
        String style = "";
        if(this.fillColor == null){
            style += "fill: transparent;";
        }else{
            style += "fill: ";
            style += this.fillColor + ";";
        }
        if(this.strokeColor == null){
            style += "stroke: black;";
        }else{
            style += "stroke: " + this.strokeColor + ";";
        }
        if(this.strokeWidth == null){
            style += "stroke-width: 1px;";
        }else{
            style += "stroke-width: "+this.strokeWidth + ";";
        }
        return style;
    }
}
