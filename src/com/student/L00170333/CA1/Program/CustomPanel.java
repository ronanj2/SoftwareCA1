package com.student.L00170333.CA1.Program;

import com.student.L00170333.CA1.Shapes.Point;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This allows us to create a panel which we can add to a frame/window
 * Oftentimes, you would then add standard GUI components, e.g. JButton, JLabel, to the
 * panel.
 * In our case, though, we will want to draw shapes, so we override the paintComponent() method
 * that we inherit from the javax.swing.JPanel class.
 * The graphics system passes us a java.awt.Graphics object and this has methods which allows us
 * to draw shapes.
 */
public class CustomPanel extends JPanel {
    public ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapesManager) {
        this.shapesManager = shapesManager;

        addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                // Write the mousePressed event to the console
                System.out.println(e.toString());

                // Get position of click on the panel
                java.awt.Point mousePoint = e.getComponent().getMousePosition();
                Point clickPoint = new Point(mousePoint.x, mousePoint.y);

                // which mouse button was clicked
                int buttonClicked = e.getButton();

                Boolean shapeClicked = shapesManager.HandleMouseClick(clickPoint, buttonClicked);

                if (shapeClicked)
                    repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // provide the graphics context to the shapesManager and have it draw its shapes
        shapesManager.drawShapes(g);
    }
}
