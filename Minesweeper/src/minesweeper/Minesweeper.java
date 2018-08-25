/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import minesweeper.model.Game;

/**
 *
 * @author carloslozano
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Game currentGame = new Game();
       currentGame.startGame();
    }
    
}
