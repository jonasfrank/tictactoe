/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.*;

/**
 *
 * @author jonasfrank
 */
public class TicTacToe {
    
    public static Scanner scan = new Scanner(System.in);
    
    private static void welcomeScreen() {
        System.out.println(" ____  ____   ___        ____    __     ___       ____  _____  ____ ");
        System.out.println("(_  _)(_  _) / __) ___  (_  _)  /__\\   / __) ___ (_  _)(  _  )( ___)");
        System.out.println("  )(   _)(_ ( (__ (___)   )(   /(__)\\ ( (__ (___)  )(   )(_)(  )__) ");
        System.out.println(" (__) (____) \\___)       (__) (__)(__) \\___)      (__) (_____)(____)");
       
        String x = " X ";
        String o = " O ";
        boolean validInput = false;
        System.out.println("1. Player vs Player\n"
                + "2. Player vs Bot\n"
                + "3. Quit\n");
       
        while (validInput == false) { // Loop för menyval, val anropar olika metoder
            String menuSelection = scan.nextLine();
            switch (menuSelection) {
                case "1":
                    initializePlayerGame();
                    validInput = true;
                    break;

                case "2":
                    initializeBotGame();
                    validInput = true;
                    break;

                case "3":
                    System.exit(0);
                    validInput = true;
                    break;

                default:
                    System.out.println("Bad input.");
            }
        }
    }
    
    
    private static void initializePlayerGame() {   // Skapar en lista med instanser av classen Player, konstruerar med namn-input
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("First player name: ");
        String firstPlayerName = scan.nextLine();
        System.out.print("Second player name: ");
        String secondPlayerName = scan.nextLine();
        players.add(new Human(firstPlayerName, " X "));
        players.add(new Human(secondPlayerName, " O "));
        game(players);
    }
    
    
    private static void initializeBotGame() { 
        ArrayList<Player> players = new ArrayList<>(); // Skapar en lista med instanser av classen Player, en Human med namn-input och bot efter val
        
        System.out.print("Your name: ");
        String playerName = scan.nextLine();
        players.add(new Human(playerName, " X "));
        System.out.println("Bot difficulty: \n"
                + "1. Easy \n"
                + "2. Normal\n"
                + "3. Hard");
        String botDifficultySelection = scan.nextLine();
        switch (botDifficultySelection) {
            case "1":
                players.add(new Bot());
                break;
            case "2":
                players.add(new BotNormal());
                break;
            case "3":
                players.add(new BotHard());
                break;
        }
        game(players);
    }
    
    
    private static void game(ArrayList<Player> players) {
        int turns = 0; // Räknar spelade turns
        boolean winnerFound;
        boolean running = true;
        Board board = new Board(); // Skapar spelbräde
        board.clearConsole();
        board.emptyBoard();
        board.printBoard();
        do { // Loop för spel
            for (int i = 0; i < players.size(); i++) { // För varje spelare i listan, utför turn()[Player.java] och skriv ut brädet
                turns += players.get(i).turn(players.get(i), board);
                board.printBoard();
                if (turns >= 4) { // Om turns är 4 eller mer (första tillfället någon kan vinna) så uför checkWinner[Board.java] efter varje turn
                    winnerFound = board.checkWinner(players.get(i).getCharacter());
                    if (winnerFound == true) { // Om vinnare hittas, stäng av loopen för spelet, ge spelare poäng och skriv ut spelare+poäng
                        running = false;
                        players.get(i).increaseScore();
                        for (int j = 0; j < players.size(); j++) {
                            System.out.println(players.get(j).getName() + ": " 
                                    + players.get(j).getScore() + " points\n");
                        }
                        break;
                    }
                }
                if (turns == 9) { // Om turns är 9 och ingen vinnare hittats är spelet oavgjort, loop för spel stängs av
                    running = false;
                    break;
                }
            }
        } while (running == true);
        if (turns == 9) {
            System.out.println("Match was a draw!");
        }
        endScreen(players);
    }
    
    
    public static void endScreen(ArrayList<Player> players) { // Ger användare val om att spela igen, ny match eller stänga av
        System.out.println("1. Rematch\n"
                + "2. New game\n"
                + "3. Quit\n");
        String menuSelection = scan.nextLine();
        switch (menuSelection) {
            case "1":
                Collections.reverse(players);
                game(players);
            case "2":
                welcomeScreen();
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Bad input");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        welcomeScreen();
    }
    
}
