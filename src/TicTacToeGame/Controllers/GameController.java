package TicTacToeGame.Controllers;

import TicTacToeGame.Models.Game;
import TicTacToeGame.Models.GameStatus;
import TicTacToeGame.Models.Player;

import java.util.ArrayList;

public class GameController {

    // Undo
    public void undo(Game game){

    }

    // createGame
    public Game createGame(int dimensions , ArrayList<Player> players){
        return Game.getBuilder()
                    .setDimensions(dimensions)
                        .setPlayers(players)
                            .Build();
    }

    // executeNextMove

    public void executeNextMove(Game game){
        game.makeMove();
    }

    // getGameState
    public GameStatus getGameState(Game game){
        return game.getGameStatus();
    }

    public void display(Game game){
        game.display();
    }

    public Player getGameWinner(Game game){
        return game.getWinner();
    }

}
