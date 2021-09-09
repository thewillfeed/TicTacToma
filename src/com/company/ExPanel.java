package com.company;

import javax.swing.*;

public class ExPanel extends JPanel {
    public ExPanel(){
        JTextField textField = new JTextField(20);
        add(textField);

        JLabel label = new JLabel("ВВедите логин");
        add(label);

        JButton button = new JButton("Войти");
        add(button);

        button.addActionListener(new ExAction(label,textField));
    }
}
