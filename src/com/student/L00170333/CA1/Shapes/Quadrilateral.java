package com.student.L00170333.CA1.Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Quadrilateral extends Shape implements Rotatable {
    private final Point[] points;

    public Quadrilateral(Point centerPoint, Point[] points, Color color, Boolean isFilled) {
        super(centerPoint.x, centerPoint.y, color, isFilled);
        this.points = points;
        setupBoundingBox();
    }

    public Quadrilateral(Point centerPoint, Point[] points) {
        super(centerPoint.x, centerPoint.y, Color.yellow, true);
        this.points = points;
        setupBoundingBox();
    }

    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4) {
        this(centerPoint, new Point[] { p1, p2, p3, p4}, Color.yellow, true);
    }

    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4, Color color, Boolean isFilled) {
        this(centerPoint, new Point[] { p1, p2, p3, p4}, color, isFilled);
    }

    /**
     * Constructs a <code>Quadrilateral</code> using a {@link Rectangle} object as input. This ctor uses the
     * vertices, center point, color and isFilled of the <code>Rectangle</code> to construct
     * the <code>Quadrilateral</code>>.
     * @param rectangle is a {@link Rectangle} object.
     */
    public Quadrilateral(Rectangle rectangle) {
        this(rectangle.getCenterPoint(), rectangle.getVertices(), rectangle.color, rectangle.isFilled);
    }

    /**
     * Method returns two arrays containing the X points and Y points.
     * @return a Pair record containing X points and Y points.
     */
    private Pair<int[], int[]> getXYPoints() {
        // We know that a quadrilateral will have 4 vertices. However, we have built out this class
        // such that it can support any number of vertices. This will allow proper code reuse in future
        // when we start to draw polygons with any number of vertices.
        int[] xPoints = new int[points.length];
        int[] yPoints = new int[points.length];

        for (int i=0; i<= points.length-1; i++) {
            xPoints[i] = points[i].x;
            yPoints[i] = points[i].y;
        }

        return new Pair<>(xPoints, yPoints);
    }

    @Override
    public void drawShape(Graphics g) {
        g.setColor(super.color);

        Pair<int[], int[]> pointPair = getXYPoints();
        int[] xPoints = pointPair.getFirst();
        int[] yPoints = pointPair.getSecond();

        if (isFilled)
            g.fillPolygon(xPoints, yPoints, xPoints.length);
        else g.drawPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public void setupBoundingBox() {
        int smallestX = Integer.MAX_VALUE;
        int smallestY = Integer.MAX_VALUE;
        int biggestX = 0;
        int biggestY = 0;

        for (Point point : points) {
            if (point.x < smallestX)
                smallestX = point.x;
            if (point.x > biggestX)
                biggestX = point.x;
            if (point.y < smallestY)
                smallestY = point.y;
            if (point.y > biggestY)
                biggestY = point.y;
        }

        Point bottomLeft = new Point();
        bottomLeft.x = smallestX;
        bottomLeft.y = biggestY;

        Point topRight = new Point();
        topRight.x = biggestX;
        topRight.y = smallestY;
        boundingBox = new BoundingBox(bottomLeft, topRight);
    }

    @Override
    public Point getStartingPoint() {
        return points[0];
    }

    /**
     * Rotates the <code>Quadrilateral</code> ninety degrees around the shape's center point.
     */
    @Override
    public void rotateNinetyDegrees() {
        // First, we must convert 90 degrees to radians
        double angle = 90 * Math.PI/180;

        // Get two arrays, one containing the X points and one containing the Y points
        Pair<int[], int[]> pointsPair = getXYPoints();
        int[] xPoints = pointsPair.getFirst();
        int[] yPoints = pointsPair.getSecond();

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        for(int n=0; n<xPoints.length; n++){
            double temp = ((xPoints[n] - xCenter) * cos - (yPoints[n] - yCenter) * sin) + xCenter;
            yPoints[n] = (int)Math.round((xPoints[n]-xCenter)*sin + (yPoints[n]-yCenter)*cos) + yCenter;
            xPoints[n] = (int)Math.round(temp);
        }

        // we need to replace the points with our new rotated points
        for (int i=0; i<=points.length-1; i++) {
            points[i].x = xPoints[i];
            points[i].y = yPoints[i];
        }

        setupBoundingBox();
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral with points=%s which is a subclass of %s",
                Arrays.toString(this.points), super.toString());
    }
}