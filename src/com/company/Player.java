package com.company;

public class Player {
    private String playerName;
    private int wins;
    private int loses;
    private Character spottingMark;
    private Character spareSpottingMark;

    public Character getSpottingMark() {
        return spottingMark;
    }

    public Character getSpareSpottingMark() {
        return spareSpottingMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String newName){
        playerName = newName;
    }


    public Player(String name, Character spottingMark, Character spareSpottingMark){
        playerName = name;
        this.spottingMark = spottingMark;
    }

    public Player(String name, int wins, int loses,Character spottingMark, Character spareSpottingMark){
        playerName = name;
        this.wins = wins;
        this.loses = loses;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", wins=" + wins +
                ", loses=" + loses +
                '}';
    }
}
