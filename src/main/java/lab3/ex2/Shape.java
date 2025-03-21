package main.java.lab3.ex2;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    protected String color;

    public abstract int getArea();
    public abstract String getType();
    public String getColor() {
        return color;
    }
    public static void countShapesInArray(Shape[] shapes) {
        int count = 0;
        List<String> shapeTypes = new ArrayList<>();
        for (Shape shape : shapes) {
            if(shapeTypes.contains(shape.getType())) {
                continue;
            } else {
                shapeTypes.add(shape.getType());
            }
        };
        int[] numberOfTypes = new int[shapeTypes.size()];
        for (Shape shape : shapes) {
            for(int i = 0; i < shapeTypes.size(); i++) {
                if(shapeTypes.get(i).equals(shape.getType())) {
                    numberOfTypes[i]++;
                }
            }
        }
        for(int i = 0; i < numberOfTypes.length; i++) {
            System.out.print(numberOfTypes[i] + "; ");
        }

    }
    public static void randomShape(Shape[] shapes) {
        int bigestShape = -1;
        Shape bigShape = null;
        for(Shape shape: shapes) {
            if(shape.getArea()>bigestShape) {
                bigestShape = shape.getArea();
                bigShape = shape;
            }
            System.out.println(bigShape.getType());
        }
    }

    public static Shape searchColor(Shape[] shapes, String color) {
        for(Shape shape: shapes) {
            if(shape.getColor().equals(color)) {
                return shape;
            }
        }
        return null;
    }


}
