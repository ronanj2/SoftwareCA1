package com.student.L00170333.CA1.Program;

import com.student.L00170333.CA1.Shapes.*;
import com.student.L00170333.CA1.Shapes.Point;
import com.student.L00170333.CA1.Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

/**
 * ShapesManager is used to manage an ArrayList of {@link Shape}'s. It is responsible for
 * drawing the shapes and handling mouse click events.
 */
public class ShapesManager {
    private final ArrayList<Shape> shapes;
    private boolean displayName;
    private boolean displayBoundingBox;

    public ShapesManager() {
        this.shapes = new ArrayList<>();
    }

    /**
     * Adds a {@link Shape} to the shapes array.
     * @param shape a {@link Shape} object.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
        //shape.toString();
    }

    /**
     * Draws all shapes to the provided graphics context.
     * @param g is the graphics context.
     */
    public void drawShapes(Graphics g) {
        for (Shape shape : shapes) {
            shape.drawShape(g, displayName, displayBoundingBox);
        }
    }

    /**
     * Set whether the {@link Shape}'s name should be displayed.
     * @param displayName Boolean to indicate whether name should be displayed.
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    /**
     * Set whether the {@link BoundingBox} should be displayed.
     * @param displayBoundingBox is a Boolean to indicate whether {@link BoundingBox} should be displayed.
     */
    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }

    /**
     * Method accepts a clickedPoint and detects if that point falls inside the {@link BoundingBox}' of
     * any shapes in the shapes array.
     * @param clickedPoint is the coordinate of the mouse click.
     * @param mouseButton is the mouse button that was clicked.
     * @return Boolean to indicate if one or more shapes were clicked.
     */
    public Boolean HandleMouseClick(Point clickedPoint, int mouseButton) {
        // return Boolean if shape clicked, this will save repainting unless necessary
        boolean shapeClicked = false;

        for (Shape shape : shapes) {
            if (shape.isContainingPoint(clickedPoint)) {
                shapeClicked = true;
                shape.toggleFilled();
                System.out.println(shape);

                if (mouseButton == 3) {
                    if (shape instanceof Moveable moveable) {
                        moveable.moveTenUnits();
                    } else if (shape instanceof Rotatable rotatable) {
                        rotatable.rotateNinetyDegrees();
                    }
                }
            }
        }
        return shapeClicked;
    }
}