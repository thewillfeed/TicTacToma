package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class TheGame {

    int playerNum = 1;
    boolean isFirstPlayerTurn;  //Так как игра предназначена для двух игроков,
    boolean isPlayingVersusBot; //в данном контексте не вижу смысла усложнять систему и делать все через массив ходов, когда можно обойтись одним bool
    String[][] field;//
    int[][] detectionField;//Maybe I should pass it to some Methods
    int fieldSize; //возможно это можно занести в методы

    void InitializeGame(int fieldSize, boolean isPlayingVersusBot){
        InitializeField(fieldSize);
        isFirstPlayerTurn = true;
        this.isPlayingVersusBot = isPlayingVersusBot;
    }

//    public void InitializeField(){
//        field = new int[3][3];   //Initializing fields with base or custom sizes;
//        rowSize = 3;
//    }

    void FillTheField(String[][] field,int[][]detectionField){
        int fieldSize =  field.length;
        for(int i = 0; i<fieldSize;i++){
            for(int g = 0; g<fieldSize;g++){
                field[i][g]="-";
                detectionField[i][g]=0;
            }
        }
    }

    void InitializeField(int Size){
        field = new String[Size][Size];
        detectionField = new int[Size][Size];  //Detection array to make it possible to detect win
        fieldSize = Size;
        FillTheField(field,detectionField);
    }

    public void StartTheGame(Player playerOne, Player playerTwo){     //standard rules applied atm
        InitializeGame(3,false);
        while(true){        //main gameplay block
            DrawField(field); //Drawing out a field
            if(isFirstPlayerTurn) TurnSequence(playerOne);  //Choosing who to play
            else TurnSequence(playerTwo);
        }
    }

    void TurnSequence(Player player){
        //main gameplay block
            int[] input = ScanInput(playerNum);  //Scanning for player input
            if(input==null)return;  //stopping if encountered error  //TODO:Ход надо вынести в отдельный список
            MarkTheSpot(input,player); //Если мы пересоздаем объекты, то не сможем изменять статистику изначальных
            GiveTurnToAnotherPlayer();
    }

    @SuppressWarnings("DuplicatedCode")
    void WinConditionCheck(int[][] conditionArray, int fieldSize, Player player){

        int temp = 0;

        for(int i = 0; i<fieldSize;i++){
            temp = 0;
            for(int g = 0; g<fieldSize;g++){    //проверяем строки
                temp+=conditionArray[i][g];
            }
            if(Math.abs(temp)==fieldSize) {
                DeclareWinner(player);
                return;
            }
        }

        for(int i = 0; i<fieldSize;i++){
            temp = 0;
            for(int g = 0; g<fieldSize;g++){    //проверяем столбцы
                temp+=conditionArray[g][i];
            }
            if(Math.abs(temp)==fieldSize) {
                DeclareWinner(player);
                return;
            }
        }

        temp = 0;
        for(int i = 0; i< fieldSize;i++){       //проверяем первую диагональ
            temp+=conditionArray[i][i];
        }
        if(Math.abs(temp)==fieldSize) {
            DeclareWinner(player);
            return;
        }

        temp = 0;
        for(int i = 0; i< fieldSize;i++){       //проверяем вторую диагональ
            temp+=conditionArray[fieldSize - i][i];
        }
        if(Math.abs(temp)==fieldSize) {
            DeclareWinner(player);
            return;
        }
    }

    void DeclareWinner(Player player){
        System.out.println(player.getPlayerName()+" wins!");
    }


    void GiveTurnToAnotherPlayer(){   //Это не очень вариант, потому что он использует глобальную переменную
        if(isFirstPlayerTurn) {
            isFirstPlayerTurn = false;
            playerNum = 2;
        }
        else {
            isFirstPlayerTurn = true;
            playerNum = 1;
        }
    }

    void MarkTheSpot(int[] inputArr,Player markingPlayer){  //TODO Играбельный билд должен быть уже завтра
        if(field[inputArr[0]][inputArr[1]].equals('-'))
        field[inputArr[0]][inputArr[1]] = markingPlayer.getSpottingMark().toString(); //Чтобы правильно получать нужную метку
        if(isFirstPlayerTurn) detectionField[inputArr[0]][inputArr[1]] = -1;
        else detectionField[inputArr[0]][inputArr[1]] = 1; //каждый раз возможно придется создавать новых игроков вначале матча и давать им метки
    }

    int[] ScanInput(int currentPlayer){
        Scanner myScan = new Scanner(System.in);
        while(true){
            System.out.printf("Player %d, Please choose correct spot to mark%n",currentPlayer);
            System.out.println("Input should look like this: 2 1");
            String input = myScan.nextLine(); //Player input handling
            String[] splittedInp = input.split(" ");
            int[] convertedInp = Arrays.stream(splittedInp).mapToInt(Integer::parseInt).toArray(); //basically converting to int through stream
            if(input.equals("4 4")){
                return null;
            }
            else if(Integer.parseInt(splittedInp[0])<fieldSize && Integer.parseInt(splittedInp[1])<fieldSize){
                return convertedInp;
            }
            else{
                System.out.println("Please insert correct input which should look like this: ");
                System.out.println("2 1");
            }
        }
    }

    void DrawField(String[][] fieldArray){  //Array as parameter is required
        for(int i = 0; i<20; i++){
            System.out.println();   //Emptying space
        }
        for(int i = 0; i<fieldArray.length; i++){
            for(int g = 0; g<fieldArray.length;g++){
                System.out.print(fieldArray[i][g]);
                if(g<fieldArray.length-1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
