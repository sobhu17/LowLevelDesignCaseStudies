package Main.Strategies;

import Main.Models.Board;
import Main.Models.Moves;
import Main.Models.Player;

public interface GameWinningStrategy {
    public boolean checkWinner(Player player , Board board , Moves move);
}
