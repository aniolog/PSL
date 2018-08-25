/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author carloslozano
 */
public class Game {

    private Cell[][] board;
    
    public Game() {
        String boardConfigStr = this.readInput("Type your board configuration:");
        String [] boardConfig =  boardConfigStr.split(" ");
        int xAxis = Integer.parseInt(boardConfig[0]);
        int yAxis = Integer.parseInt(boardConfig[1]);
        int mineCount = Integer.parseInt(boardConfig[2]);
        initBoard(xAxis, yAxis, mineCount);
        
    }
    
    private String readInput(String message) {
        try {
           System.out.print(message);
           BufferedReader reader = 
                   new BufferedReader(new InputStreamReader(System.in));
           return reader.readLine();   
        } catch (Exception e) {
            return null;
        }
    }
    
    private void initBoard(int xAxis, int yAxis, int mineCount){
        this.board = new Cell[xAxis][yAxis];
        for (int mine =0; mine<mineCount; mine++){
            this.buildMine();
        }
        for(int xIndex = 0; xIndex< this.board.length; xIndex++) {
            for(int yIndex = 0; yIndex< this.board[xIndex].length; yIndex++) {
              if (this.board[xIndex][yIndex] == null) {
                  this.board[xIndex][yIndex] = new Cell(false, '.', false);
              }
            }
        }  
    }
    
    private void buildMine() {
        Random xRandom = new Random();
        Random yRandom = new Random();
        boolean hasFoundCell = false;
        while (!(hasFoundCell)) {
          int xPosition = xRandom.nextInt(this.board.length);
          int yPosition = yRandom.nextInt(this.board.length);
          if (this.board[xPosition][yPosition] == null) {
              this.board[xPosition][yPosition] = new Cell(true, '*', false);
              hasFoundCell = true;
          }
        }
    }
    
    private void renderBoard(){
        for(int xIndex = 0; xIndex< this.board.length; xIndex++) {
            for(int yIndex = 0; yIndex< this.board[xIndex].length; yIndex++) {
                System.out.print(this.board[xIndex][yIndex].mask()+" ");
            }
            System.out.println();
        }
    }
    
    private void move() {
        String[] move = this.readInput("type your move: ").split(" ");
        int xAxis = Integer.parseInt(move[0]);
        int yAxis = Integer.parseInt(move[1]);
        String moveType = move[2];
    }
    
    public void startGame() {
        boolean gameHasEnded = false;
        while (!(gameHasEnded)) {
            this.renderBoard();
            this.move();
            gameHasEnded = true;
        } 
    }
}
