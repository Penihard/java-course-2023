package edu.hw2.rectangleTask;

public class Square extends Rectangle {

    public Square(int value) {
        super(value, value);
    }

    @Override
    public Square setWidth(int value) {
        return new Square(value);
    }

    @Override
    public Square setHeight(int value) {
        return new Square(value);
    }
}
