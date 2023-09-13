package Main.Models;

import Main.Strategies.GameWinningStrategy;
import Main.Strategies.OrderOneGameWinningStrategy;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Player> players;
    private int nextPlayerIndex;
    private Player winner;
    private GameStatus gameStatus;
    private ArrayList<Moves> moves;
    private GameWinningStrategy gameWinningStrategy;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public ArrayList<Moves> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Moves> moves) {
        this.moves = moves;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    private Game(Builder b){
        this.board = new Board(b.dimensions);
        this.players = b.players;
        this.nextPlayerIndex = 0;
        this.gameStatus = GameStatus.INPROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gameWinningStrategy = new OrderOneGameWinningStrategy(b.dimensions);
    }


    public void undo(Game game){

    }

    public void display(){
        this.board.display();
    }

    public void makeMove(){
        Player playerTurn = players.get(nextPlayerIndex);

        System.out.println("It is " + players.get(nextPlayerIndex).getName() + "'s turn.");

        Moves move = playerTurn.makeNextMove(this.board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Move happened at " + row + "th row and " + col + "th column");

        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerTurn);

        Moves finalMove = new Moves(playerTurn , board.getBoard().get(row).get(col));

        this.moves.add(finalMove);

        if(gameWinningStrategy.checkWinner(playerTurn , board ,finalMove) == true){
            winner = playerTurn;
            gameStatus = GameStatus.ENDED;
        }
        if(moves.size() == (board.getBoard().size() * board.getBoard().size())){
            gameStatus = GameStatus.DRAW;
        }

        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
    }




    public static class Builder{
        private int dimensions;
        private ArrayList<Player> players;

        public int getDimensions() {
            return dimensions;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return  this;
        }

        public ArrayList<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(ArrayList<Player> players) {
            this.players = players;
            return this;
        }

        public Game Build(){

            // Do validations here


            return new Game(this);
        }

    }


}
