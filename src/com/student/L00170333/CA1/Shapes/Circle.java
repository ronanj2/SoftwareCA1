package com.student.L00170333.CA1.Shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A {@link Circle} inherits from {@link Shape}.
 */
public class Circle extends Shape {
    private final int radius;

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this(xCenter, yCenter, radius, Color.BLACK);
    }

    public Circle(int xCenter, int yCenter, int radius, Color color) {
        this(xCenter, yCenter, radius, color, false);
    }

    public Circle(int xCenter, int yCenter, int radius, Color color, Boolean isFilled) {
        super(xCenter, yCenter, color, isFilled);
        this.radius = radius;
        setupBoundingBox();
    }

    @Override
    public void drawShape(Graphics g) {
        g.setColor(super.color);
        Point startingPoint = getStartingPoint();

        if (isFilled)
            g.fillOval(startingPoint.x, startingPoint.y, this.radius*2, this.radius*2);
        else g.drawOval(startingPoint.x, startingPoint.y, this.radius*2, this.radius*2);
    }

    @Override
    public void setupBoundingBox() {
        Point bottomLeft = getStartingPoint();
        bottomLeft.y += radius*2;

        Point topRight = getStartingPoint();
        topRight.x += radius*2;

        boundingBox = new BoundingBox(bottomLeft, topRight);
    }

    @Override
    public Point getStartingPoint() {
        Point startingPoint = new Point();
        startingPoint.x = xCenter - radius;
        startingPoint.y = yCenter - radius;
        return startingPoint;
    }

    @Override
    public String toString() {
        return String.format("Circle with radius=%s which is a subclass of %s",
                this.radius, super.toString());
    }
}