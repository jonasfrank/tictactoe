/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


/**
 *
 * @author jonasfrank
 */
public class Board {
    String[] gameboard = new String[9]; // Brädet
    String empty = "   ";
    
    
    public String[] getGameboard(){ // Hämta gameBoard (Bot)
        return gameboard;
    }
    
    public void printBoard() { 
        System.out.println("\t" + gameboard[0] + "|" + gameboard[1] + "|" + gameboard[2] + "\n"
                + "\t---+---+---\n" + 
                "\t" + gameboard[3] + "|" + gameboard[4] + "|" + gameboard[5] + "\n" + 
                "\t---+---+---\n" + 
                "\t" + gameboard[6] + "|" + gameboard[7] + "|" + gameboard[8] + "\n");
    }
    
    public void emptyBoard() { // Fyller listan för brädet med 3 mellanrum för att behålla struktur
        for (int i = 0; i < gameboard.length; i++) {
            gameboard[i] = empty;
            
        }
    }
    
    public void clearConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public boolean checkAndMakeMove(int spotInput, Player player){ // Tittar om vald plats i brädet är ledig, returnerar boolean
        spotInput = spotInput - 1;
        if (gameboard[spotInput].equals(empty)) {
            gameboard[spotInput] = player.getCharacter();
            return true;
        } else {
            return false;
        }
    }
    

    
    public boolean checkWinner(String a) { // Jämför alla vinnande stadier av spelbrädet med en spelares karaktär (X/O)
        return gameboard[0].equals(a) && gameboard[1].equals(a) && gameboard[2].equals(a) ||   // Horisontell
                gameboard[3].equals(a) && gameboard[4].equals(a) && gameboard[5].equals(a) ||
                gameboard[6].equals(a) && gameboard[7].equals(a) && gameboard[8].equals(a) ||
                gameboard[0].equals(a) && gameboard[3].equals(a) && gameboard[6].equals(a) ||  // Vertikal
                gameboard[1].equals(a) && gameboard[4].equals(a) && gameboard[7].equals(a) ||
                gameboard[2].equals(a) && gameboard[5].equals(a) && gameboard[8].equals(a) ||
                gameboard[0].equals(a) && gameboard[4].equals(a) && gameboard[8].equals(a) || // Diagonal
                gameboard[2].equals(a) && gameboard[4].equals(a) && gameboard[6].equals(a);
    }
}

