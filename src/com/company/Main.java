package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Player boyd = new Player("Boyd",'x','y');
    Player raz = new Player("Raz",'x','z');   //test players
    System.out.println(boyd);
    TheGame theGame = new TheGame();
    //theGame.DrawField();
    theGame.StartTheGame(boyd,raz);
    }
}
