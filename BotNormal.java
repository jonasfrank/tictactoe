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
public class BotNormal extends Player{
    
    public BotNormal() {
        name = "HAL 9000";
        character = " O ";
    }
    @Override
    public int turn(Player player, Board board) {

    return 1;
    }
}
