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
abstract class Player {
    String name;
    String character;
    int score;
    Random rng = new Random();
    Scanner sc = new Scanner(System.in);
    
    public String getName(){
        return name;
    }
    
    public String getCharacter() {
        return character;
    }
    
    public int getScore() {
        return score;
    }
    
    public void increaseScore() {
        score++;
    }
    
    public int randomizer(int max){ // Tar fram randomsiffra, används bara utav bots
        int randomNumber = rng.nextInt(max - 1 + 1) + 1;
        return randomNumber;
    }
    
    public int turn(Player player, Board board) {  // Tar emot input och passar den till checkAndMakeMove, om true returneras avsluta loop
        boolean validMove = false;                  // GÖR OM TILL ABSTRACT
        System.out.println(name + ", make your move! (1-9)");
        while (validMove == false) {
            int selectedMove = sc.nextInt();
            sc.nextLine();
            validMove = board.checkAndMakeMove(selectedMove, player);
            
        }
        return 1;
    }
    
    
    
    
    
    //MINIMAX-TESTER
    
    /*public String[] cloneGameboard(Board board) {
        String[] clonedBoard = board.getGameboard().clone();
        return clonedBoard;
    }
    
    public int[] possibleMoves(Board board) {
        List<Integer> movesList = new LinkedList<>();
        for (int i = 0; i < board.getGameboard().length; i++) {
            if (board.getGameboard()[i].equals("   ")) {
                movesList.add(i);
            }
        }
        int[] array = new int[movesList.size()];
        return array;
    }
    
    
    public int minimax(Board board) {
        if (board.checkWinner(" O ")) {
            return 100;
        }
        if (board.checkWinner(" X ")) {
            return -100;
        }
        if (possibleMoves(board).length == 0) {
            return 0;
        }

        
        return 100;
    }*/
    
            
}

