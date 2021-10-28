package com.student.L00170333.CA1.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/**
 * A {@link Rectangle} inherits from {@link Shape} and implements {@link Moveable}.
 */
public class Rectangle extends Shape implements Moveable {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(int xCenter, int yCenter, int width, int height) {
        this(xCenter, yCenter, width, height, Color.BLACK);
    }

    public Rectangle(int xCenter, int yCenter, int width, int height, Color color) {
        this(xCenter, yCenter, width, height, color, false);
    }

    public Rectangle(int xCenter, int yCenter, int width, int height, Color color, Boolean isFilled) {
        super(xCenter, yCenter, color, isFilled);
        this.width = width;
        this.height = height;
        setupBoundingBox();
    }

    @Override
    public void moveTenUnits() {
        xCenter+=10;
        setupBoundingBox();
    }

    @Override
    public void setupBoundingBox() {
        Point bottomLeft = getStartingPoint();
        bottomLeft.y += height;

        Point topRight = getStartingPoint();
        topRight.x += width;

        boundingBox = new BoundingBox(bottomLeft, topRight);
    }

    /**
     * {@inheritDoc}
     * @param g is the graphics context.
     */
    @Override
    public void drawShape(Graphics g) {
        g.setColor(super.color);
        Point startingPoint = getStartingPoint();

        if (isFilled)
            g.fillRect(startingPoint.x, startingPoint.y, this.width, this.height);
        else g.drawRect(startingPoint.x, startingPoint.y, this.width, this.height);
    }

    /**
     * Method returns the vertices of the <code>Rectangle</code>.
     * @return array containing co-ordinates for each of vertices.
     */
    public Point[] getVertices() {
        Point[] points = new Point[4];
        points[0] = getStartingPoint();

        Point topRight = getStartingPoint();
        topRight.x += this.width;
        points[1] = topRight;

        Point bottomRight = getStartingPoint();
        bottomRight.x += this.width;
        bottomRight.y += this.height;
        points[2] = bottomRight;

        Point bottomLeft = getStartingPoint();
        bottomLeft.y += this.height;
        points[3] = bottomLeft;

        return points;
    }

    @Override
    public Point getStartingPoint() {
        Point startingPoint = new Point();
        startingPoint.x = xCenter - this.width / 2;
        startingPoint.y = yCenter - this.height / 2;
        return startingPoint;
    }

    @Override
    public String toString() {
        return String.format("%s with side=%s and height=%s and with vertices at %s. It is a subclass of %s",
                this.getShapeName(), this.width, this.height, Arrays.toString(this.getVertices()), super.toString());
    }
}