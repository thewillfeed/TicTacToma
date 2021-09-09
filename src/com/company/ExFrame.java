package com.company;

import javax.swing.*;
import java.awt.*;

public class ExFrame extends JFrame {
    public ExFrame(){
        setSize(300,300);
        setTitle("Tic Tac Toma");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ExPanel panel = new ExPanel();
        Container container = getContentPane();
        container.add(panel);

        //getContentPane().add(new ExPanel());
    }

}
