package com.company;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean isGameOn = true;
        Scanner myScan = new Scanner(System.in);
        Player boyd = new Player("Player 1",'x','y');
        Player raz = new Player("Player 2",'o','z');   //test players
        TheGame theGame = new TheGame();
        int fieldSize = 3;

        /*
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        JButton[][] buttons = new JButton[fieldSize][fieldSize];
        for(int i = 0; i < fieldSize;i++){
            for(int j = 0; j < fieldSize; j++){
                JButton button = new JButton("-");
                buttons[i][j] = button;
                int in = i;
                int ji = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) { //TODO надо вызывать action из input a
                        if(theGame.isFirstPlayerTurn){
                            button.setText(raz.getSpottingMark().toString());  //
                            theGame.field[in][ji] = boyd.getSpottingMark().toString();
                            theGame.detectionField[in][ji] = -1;//Нужен метод, который будет все переставлять
                                //здеся будет detection field
                        }
                        else{
                            button.setText(boyd.getSpottingMark().toString());
                        }
                    }
                });
                buttonPanel.add(button);
            }


        }

        buttonPanel.setPreferredSize(new Dimension(300, 400));
        containerPanel.add(buttonPanel);
        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setVisible(true);
        */

        while(isGameOn){
            System.out.println("Welcome to the Tic Tac toe.");
            System.out.println("Type 1 to start the game");
            System.out.println("Type 2 to rename players");
            System.out.println("Type 3 to quit");
            int input = myScan.nextInt();
            switch (input){
                case 1:
                    theGame.StartTheGame(boyd,raz);
                    return;
                case 2:
                    PlayerHandler pHandler = new PlayerHandler();
                    pHandler.ChangePlayerNamesMenu(boyd,raz);
                    break;
                case 3:
                    isGameOn = false;
                    return;
            }
            //break;
        }

    //System.out.println(boyd);

        //ExFrame exFrame = new ExFrame();
       //exFrame.setVisible(true);

    //theGame.DrawField();

    }
}
