package com.student.L00170333.CA1.Shapes;

import java.awt.Color;

public class Square extends Rectangle {
    public Square(int width) {
        this(0, 0, width);
    }

    public Square(int xCenter, int yCenter, int width) {
        this(xCenter, yCenter, width, Color.BLACK);
    }

    public Square(int xCenter, int yCenter, int width, Color color) {
        this(xCenter, yCenter, width, color, false);
    }

    /**
     * Constructs a <code>Square</code> object.
     * SuspiciousNameCombination is added here to suppress the warning thrown after passing
     * width in place of height. As this is a square, the height and width are equal.
     * @param xCenter X co-ordinate of the center point
     * @param yCenter Y co-ordinate of the center point
     * @param width width of the square.
     * @param color is the color of the square.
     * @param isFilled indicates if the square should be outlined or filled.
     */
    @SuppressWarnings("SuspiciousNameCombination")
    public Square(int xCenter, int yCenter, int width, Color color, Boolean isFilled) {
        super(xCenter, yCenter, width, width, color, isFilled);
    }

    @Override
    public String toString() {
        return String.format("A %s with side=%s, which is a subclass of %s", this.getShapeName(), super.width, super.toString());
    }
}