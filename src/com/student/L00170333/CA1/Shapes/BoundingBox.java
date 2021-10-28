package com.student.L00170333.CA1.Shapes;

import java.awt.*;

/**
 * Each {@link Shape} is surrounded by an associated <code>BoundingBox</code>. We use this object to determine
 * if the mouse x,y coordinates are within the bounds of the box.
 */
public class BoundingBox {
    protected Point bottomLeft;
    protected Point topRight;

    public BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    /**
     * Determine if <code>Point</code> p's coordinates are inside this <code>BoundingBox</code>?
     * @param p is an x,y co-ordinate to check.
     * @return Boolean indicating if point is inside bounds of the <code>BoundingBox</code>.
     */
    public boolean isContainingPoint(Point p) {
        return (p.x >= bottomLeft.x && p.x <= topRight.x
                && p.y >= topRight.y && p.y <= bottomLeft.y);
    }

    /**
     * Method is called to draw the outline of the <code>BoundingBox</code> using the provided graphics context.
     * @param g is the graphics context.
     */
    public void drawOutline(Graphics g) {
        Graphics2D g2d = null;

        try {
            // Create a copy of the Graphics instance
            g2d = (Graphics2D) g.create();

            g2d.setColor(Color.black);

            // Set the stroke of the copy, not the original
            Stroke dashed = new BasicStroke(0.6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    0, new float[]{9}, 0);
            g2d.setStroke(dashed);

            int x = bottomLeft.x;
            int y = topRight.y;
            int width = topRight.x - x;
            int height = bottomLeft.y - y;

            g2d.drawRect(x, y, width, height);
        }
        finally {
            // Get rid of the copy
            if (g2d != null) {
                g2d.dispose();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Bounding box with bottomLeft: %s and topRight %s",
                bottomLeft,
                topRight
        );
    }
}