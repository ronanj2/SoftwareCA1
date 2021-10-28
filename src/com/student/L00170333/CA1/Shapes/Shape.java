package com.student.L00170333.CA1.Shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This abstract superclass is extended by the various shape classes.
 */
public abstract class Shape {
    protected Color color;
    protected Boolean isFilled;
    protected int xCenter, yCenter;
    protected BoundingBox boundingBox;

    public Shape() {
        this(0,0);
    }

    public Shape(int xCenter, int yCenter) {
        this(xCenter, yCenter, Color.BLACK);
    }

    public Shape(int xCenter, int yCenter, Color color) {
        this(xCenter, yCenter, color, true);
    }

    public Shape(int xCenter, int yCenter, Color color, Boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    /**
     * Sets up the bounding box around the shape. This method should be called after initialization
     * of the Shape object or after any positional or rotational changes.
     */
    protected abstract void setupBoundingBox();

    /**
     * Gets the starting point for drawing the object
     * @return <code>Point</code> with X,Y coordinate
     */
    protected abstract Point getStartingPoint();

    /**
     * Draw the shape using the provided graphics context. Each class inheriting must
     * implement the drawShape method.
     * @param g is the graphics context.
     */
    public abstract void drawShape (Graphics g);

    /**
     * Draw the shape using the provided graphics context.
     * @param g is the graphics context.
     * @param isDisplayName indicates whether the shape's name should display.
     * @param isDisplayBoundingBox indicates whether the shape's bounding box should display.
     */
    public void drawShape(Graphics g, Boolean isDisplayName, Boolean isDisplayBoundingBox) {
        drawShape(g);

        if (isDisplayName) {
            drawDisplayName(g);
        }

        if (isDisplayBoundingBox) {
            drawBoundingBox(g);
        }
    }

    /**
     * Draw the shape's name using the provided graphics context.
     * @param g is the graphics context.
     */
    protected void drawDisplayName(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString(getShapeName(), xCenter, yCenter);
    }

    /**
     * Draw the shape's bounding box outline using the provided graphics context.
     * @param g is the graphics context.
     */
    protected void drawBoundingBox(Graphics g) {
        boundingBox.drawOutline(g);
    }

    /**
     * Returns the simple name of the underlying class as given in the source code.
     * @return the shape name.
     */
    protected String getShapeName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Gets the center point coordinate of the shape (X,Y).
     * @return the center point coordinate (X,Y).
     */
    protected Point getCenterPoint() {
        return new Point(xCenter, yCenter);
    }

    /**
     * Determine if <code>Point</code> p's co-ordinates fall inside the <code>Shape</code>'s {@link BoundingBox}.
     * @param point X,Y coordinate to check.
     * @return Boolean to indicate if 'point' is inside bounding box.
     */
    public Boolean isContainingPoint(Point point) {
        if (boundingBox == null)
            return false;

        return boundingBox.isContainingPoint(point);
    }

    /**
     * Toggles the <code>Boolean</code> isFilled variable between true and false.
     */
    public void toggleFilled() {
        this.isFilled = !this.isFilled;
    }

    @Override
    public String toString() {
        return String.format("Shape xCenter=%s and yCenter=%s with color=%s and %s and with a %s",
                xCenter,
                yCenter,
                this.color,
                isFilled? "filled" : "not filled",
                boundingBox.toString()
        );
    }
}