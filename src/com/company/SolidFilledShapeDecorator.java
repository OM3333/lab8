package com.company;

public class SolidFilledShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFilledShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
    public String toSvg(String parameters){
        String fill = "fill=\""+this.color+"\"" + parameters;
        return super.toSvg(fill);
    }
}
