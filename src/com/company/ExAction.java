package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExAction implements ActionListener {

    private JLabel label;
    private JTextField textField;

    public ExAction(JLabel label, JTextField textField){
        this.label = label;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("!");
        this.label.setText(textField.getText());
    }
}
