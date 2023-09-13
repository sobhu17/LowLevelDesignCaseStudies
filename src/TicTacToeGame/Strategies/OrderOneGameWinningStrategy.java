package TicTacToeGame.Strategies;

import TicTacToeGame.Models.Board;
import TicTacToeGame.Models.Moves;
import TicTacToeGame.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    ArrayList<HashMap<Character , Integer>> allRows = new ArrayList<>();
    ArrayList<HashMap<Character , Integer>> allCols = new ArrayList<>();
    HashMap<Character , Integer> topLeftDiag = new HashMap<>();
    HashMap<Character , Integer> topRightDiag = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimensions){
        for(int i = 0 ; i < dimensions ; i++){
            allRows.add(new HashMap<>());
            allCols.add(new HashMap<>());
        }
    }

    public boolean isTopLeft(int row , int col){
        return row == col;
    }

    public boolean isTopRight(int row , int col , int dimensions){
        return (row + col) == (dimensions - 1);
    }

    @Override
    public boolean checkWinner(Player player, Board board, Moves move) {
        char symbol = player.getSymbol();
        int dimensions = board.getBoard().size();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (!allRows.get(row).containsKey(symbol)) {
            allRows.get(row).put(symbol, 0);
        }

        allRows.get(row).put(
                symbol,
                allRows.get(row).get(symbol) + 1
        );

        if (!allCols.get(col).containsKey(symbol)) {
            allCols.get(col).put(symbol, 0);
        }

        allCols.get(col).put(
                symbol,
                allCols.get(col).get(symbol) + 1
        );

        if (isTopLeft(row, col)) {
            if (!topLeftDiag.containsKey(symbol)) {
                topLeftDiag.put(symbol, 0);
            }

            topLeftDiag.put(
                    symbol,
                    topLeftDiag.get(symbol) + 1
            );
        }

        if (isTopRight(row, col, board.getBoard().size())) {
            if (!topRightDiag.containsKey(symbol)) {
                topRightDiag.put(symbol, 0);
            }

            topRightDiag.put(
                    symbol,
                    topRightDiag.get(symbol) + 1
            );
        }

        if (
                allRows.get(row).get(symbol) == dimensions ||
                        allCols.get(col).get(symbol) == dimensions
        ) {
            return true;
        }

        if (isTopRight(row, col, dimensions) && topRightDiag.get(symbol) == dimensions) return true;

        if (isTopLeft(row, col) && topLeftDiag.get(symbol) == dimensions) return true;

        return false;
    }
}
