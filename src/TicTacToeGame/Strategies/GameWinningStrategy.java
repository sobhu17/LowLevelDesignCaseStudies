package TicTacToeGame.Strategies;

import TicTacToeGame.Models.Board;
import TicTacToeGame.Models.Moves;
import TicTacToeGame.Models.Player;

public interface GameWinningStrategy {
    public boolean checkWinner(Player player , Board board , Moves move);
}
