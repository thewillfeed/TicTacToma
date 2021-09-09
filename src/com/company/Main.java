package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Player boyd = new Player("Player 1",'x','y');
    Player raz = new Player("Player 2",'o','z');   //test players
    System.out.println(boyd);

        //ExFrame exFrame = new ExFrame();
       //exFrame.setVisible(true);
    TheGame theGame = new TheGame();
    //theGame.DrawField();
    theGame.StartTheGame(boyd,raz);


    }
}
