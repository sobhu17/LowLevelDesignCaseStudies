package TicTacToeGame;

import TicTacToeGame.Controllers.GameController;
import TicTacToeGame.Models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        GameController gameController = new GameController();

        System.out.println("Give dimensions of the board : ");
        int dimensions = s.nextInt();

        System.out.println("Do we have bot? y/n");
        char botConfirm = s.next().charAt(0);

        int iterator = dimensions-1;

        if(botConfirm == 'y'){
            iterator = dimensions-2;
        }

        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Give players : ");
        for(int i = 0 ; i < iterator ; i++){
            System.out.println("Give name of player " + i);
            String name = s.next();

            System.out.println("Give symbol of player " + i);
            char symbol = s.next().charAt(0);

            players.add(new Player(name , symbol , PlayerType.HUMAN));
        }

        if(botConfirm == 'y'){
            System.out.println("Give name of bot ");
            String name = s.next();

            System.out.println("Give symbol of bot ");
            char symbol = s.next().charAt(0);

            players.add(new Bot(name , symbol , BotDefficultyLevel.EASY));
        }

        Game game = gameController.createGame(dimensions , players);

        while (game.getGameStatus().equals(GameStatus.INPROGRESS)){
            System.out.println("This is the current board ");
            gameController.display(game);

            System.out.println("Does anyone want's to undo ? y/n" );

            char undoConfirm = s.next().charAt(0);

            if(undoConfirm == 'n'){
                gameController.executeNextMove(game);
            }
        }

        gameController.display(game);

        if(gameController.getGameState(game).equals(GameStatus.ENDED)){
            System.out.println("The game is ended and the winner is " + gameController.getGameWinner(game).getName());
        }
        else{
            System.out.println("The game is ended and the result is DRAW");
        }
    }
}
