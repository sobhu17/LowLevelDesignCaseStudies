package TicTacToeGame.Models;

public class Bot extends Player{
    private BotDefficultyLevel botDefficultyLevel;

    public Bot(String name , char symbol , BotDefficultyLevel botDefficultyLevel){
        super(name , symbol , PlayerType.BOT);
        this.botDefficultyLevel = botDefficultyLevel;
    }

}
