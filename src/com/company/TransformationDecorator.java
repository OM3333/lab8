package com.company;

public class TransformationDecorator extends ShapeDecorator{
    private boolean translate;
    private Vec2 translateVector;
    private Shape shape;

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String toSvg(String parameters) {
        String result = "";

        if(translate) {
            result += "";
        }

        return super.toSvg(parameters);
    }

    public static class Builder{
        private boolean translate = false;
        private Vec2 translateVector;
        private Shape shape;

        public Builder(Shape shape) {
            this.shape = shape;
        }

        public Builder setTranslate(Vec2 vector){
            this.translateVector = vector;
            translate = true;
            return this;
        }

        public TransformationDecorator build(){
            TransformationDecorator result = new TransformationDecorator(shape);

            if(translate == true){
                result.translate = this.translate;
                result.translateVector = this.translateVector;
            }

            return result;
        }
    }
}
