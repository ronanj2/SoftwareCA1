package com.student.L00170333.CA1.Program;

import com.student.L00170333.CA1.Shapes.*;
import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    /**
     * main entry point for the program.
     * @param args optional arguments passed in at runtime.
     */
    public static void main(String[] args) {
        //Create and configure our JFrame (window)
        ShapesManager shapesManager = new ShapesManager();

        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(true);

        shapesManager.addShape(new Circle(300,80, 50, Color.green));
        shapesManager.addShape(new Rectangle(50,125, 50, 90, Color.blue, true));
        shapesManager.addShape(new Square(70, 160, 50, Color.yellow, false));

        shapesManager.addShape(new Quadrilateral(new Point(280,320),
                new Point(186, 233),
                new Point(400, 256),
                new Point(461, 402),
                new Point(91, 405),
                Color.MAGENTA,
                true
                ));

        // Next we use a rectangle to initialize a quadrilateral
        Rectangle rect2 = new Rectangle(140,180, 40, 30, Color.red);
        Quadrilateral quad = new Quadrilateral(rect2);
        shapesManager.addShape(quad);

        // Our Quadrilateral has been coded to support any number of points/sides. So, we could in theory
        // rename it to Polygon and then have a Quadrilateral class inheriting from Polygon, similar to the structure
        // and relationship we have between Square and Rectangle.
        // As an example, the following commented code has 7 sides, and will rotate just fine.
        /*
        Point[] pointsArray = {
                new Point(380, 72),
                new Point(550, 40),
                new Point(601, 140),
                new Point(551, 214),
                new Point(444, 240),
                new Point(336, 209),
                new Point(355, 130),
        };
        shapesManager.addShape(
            new Quadrilateral(new Point(504,98), pointsArray, Color.CYAN, true
        ));
        */

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("CA1 for Student Ronan Farrell L00170333");
        customWindow.setVisible(true);
    }
}