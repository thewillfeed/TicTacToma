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

        while(isGameOn){
            System.out.println("Welcome to the Tic Tac toe.");
            System.out.println("Type 1 to start the game");
            System.out.println("Type 2 to play with GUI");
            System.out.println("Type 3 to rename players");
            System.out.println("Type 4 to quit");

            int input = myScan.nextInt();
            switch (input){
                case 1:
                    theGame.StartTheGame(boyd,raz);
                    return;
                case 2:
                    theGame.StartTheGameWithGUI(boyd,raz);
                    break;
                case 3:
                    PlayerHandler pHandler = new PlayerHandler();
                    pHandler.ChangePlayerNamesMenu(boyd,raz);
                    break;
                case 4:
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
