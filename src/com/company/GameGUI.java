package com.company;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class GameGUI {

    //do I really need access to Panels?
    JButton[][] buttons;
    int fieldSize;

    public GameGUI(TheGame theGame, int fieldSize){
        InitializeInterface(theGame,fieldSize);
    }



    public void ShowWinnerWindow(Player winner, TheGame theGame, boolean isTie){
        JDialog dialog = new JDialog();
        JPanel mainPanel = new JPanel();
        dialog.setModal (true);
        dialog.setAlwaysOnTop (true);
        dialog.setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                theGame.ResetTheGame();
            }
        });
        if(isTie)
            mainPanel.add(new Label("TIE!", SwingConstants.CENTER));
            else
            mainPanel.add(new Label(winner.getPlayerName()+" WON! ", SwingConstants.CENTER));
        dialog.setTitle("The END");
        dialog.add(mainPanel);
//        JFrame frame = new JFrame();
//
      // Container container = frame.getContentPane();
//        mainPanel.add(new Label(winner.getPlayerName()+" WON! "));
//        frame.setTitle("THE END");
       // container.add(mainPanel);
        dialog.setSize(330,100);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void ResetGUI(){
        for(int i = 0; i<fieldSize;i++){
            for(int j = 0; j<fieldSize;j++){
                buttons[i][j].setText("-");
            }
        }
    }


    void InitializeInterface(TheGame theGame, int fieldSize){
        this.fieldSize = fieldSize;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toma");
        JPanel buttonPanel = new JPanel();          //Initialising interface
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(fieldSize,fieldSize));
        buttons = new JButton[fieldSize][fieldSize];
        for(int i = 0; i < fieldSize;i++){
            for(int j = 0; j < fieldSize; j++){
                JButton button = new JButton("-");
                buttons[i][j] = button;
                int in = i;
                int ji = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        boolean check = theGame.CheckIfPlotIsFree(in,ji);
                        if(check){
                            String mark = theGame.GUIInput(in,ji);
                            button.setText(mark);
                            theGame.CheckForWinGUIWrap();
                        }
                         //Mark is null when the field is already taken by smn

                    }
                });
                buttonPanel.add(button);
            }
        }
        buttonPanel.setPreferredSize(new Dimension(300, 400));
        containerPanel.add(buttonPanel);
        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setAlwaysOnTop (true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }




}
