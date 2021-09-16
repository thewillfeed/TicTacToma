package com.company;
import java.util.Scanner;

public class PlayerHandler {

    public void ChangePlayerNamesMenu(Player player1, Player player2){
        Scanner intScan = new Scanner(System.in);
        System.out.println("1 "+player1.getPlayerName());
        System.out.println("2 "+player2.getPlayerName());
        System.out.println("3 Back to the main menu");
        int inp = intScan.nextInt();
        Player player;
        if(inp == 1 ) player = player1; else if(inp == 2) player = player2; else return;
        System.out.println("How do you wanna rename " + player.getPlayerName());
        Scanner scan = new Scanner(System.in);
        String newName = scan.nextLine();
        player.setPlayerName(newName);
        System.out.println("Player's new name is "+ player.getPlayerName());
    }

}
