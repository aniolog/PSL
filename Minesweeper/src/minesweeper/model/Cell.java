/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.model;

/**
 *
 * @author carloslozano
 */
public class Cell {
    
    private boolean isMine;
    private char mask;
    private boolean isMarked;

    public Cell(boolean isMine, char mask, boolean isMarked) {
        this.isMine = isMine;
        this.mask = mask;
        this.isMarked = isMarked;
    }

    public boolean isMine() {
        return isMine;
    }

    public char mask() {
        return mask;
    }

    public boolean isMarked() {
        return isMarked;
    }
    
}
