package TicTacToeGame.Models;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Cell>> board;

    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Cell>> board) {
        this.board = board;
    }

    public Board(int dimensions){
        board = new ArrayList<>();

        for(int i = 0 ; i < dimensions ; i++){
            ArrayList<Cell> temp = new ArrayList<>();
            for(int j = 0 ; j < dimensions ; j++){
                temp.add(new Cell(i , j));
            }
            board.add(temp);
        }
    }

    public void display(){
        for(int i = 0 ; i < board.size() ; i++){
            for(int j = 0 ; j < board.size() ; j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.print("|   |");
                }
                else{
                    System.out.print("| " + board.get(i).get(j).getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

}
