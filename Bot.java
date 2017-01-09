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
public class Bot extends Player {
    
    
    public Bot() {
        name = "WALL-E";
        character = " 0 ";     
    }


    
    @Override
    public int turn(Player player, Board board) {
        boolean validMove = false;
        while (validMove == false) {            
            validMove = board.checkAndMakeMove(player.randomizer(9), player);
        }
        
        return 1;
    }
}
