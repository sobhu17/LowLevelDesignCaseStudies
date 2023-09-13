package TicTacToeGame.Models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(String name , char symbol , PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Moves makeNextMove(Board board){
        Scanner s = new Scanner(System.in);

        System.out.println("Please give the row no. starting from 0 : ");
        int rowNo = s.nextInt();

        System.out.println("Please give the col no. starting from 0 : ");
        int colNo = s.nextInt();

        return new Moves(this , new Cell(rowNo , colNo));
    }


}
