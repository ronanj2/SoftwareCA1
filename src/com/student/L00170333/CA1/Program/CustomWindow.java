package com.student.L00170333.CA1.Program;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * We can think of a JFrame as a window
 * By extending (inheriting from) the class javax.swing.JFrame we can
 * define what goes into our window - in this case a single JPanel which is
 * a component container for GUI elements.
 */
public class CustomWindow extends JFrame {

    public CustomWindow(ShapesManager shapesManager)
    {
        CustomPanel mainPanel = new CustomPanel(shapesManager);

        //add our new panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}
