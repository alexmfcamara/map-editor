package org.academiadecodigo.maindalorians.Grid;

import org.academiadecodigo.maindalorians.SandPlayBox;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MainGrid {
    private int cols;
    private int rows;
    private GridRectangle[] mainGrid;

    public MainGrid(){
        cols = 10;
        rows = 10;
        mainGrid = new GridRectangle[cols * rows];
    }

    public MainGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        mainGrid = new GridRectangle[cols * rows];
    }

    public int getCols(){ return cols;}
    public int getRows(){ return rows;}
    public GridRectangle[] getMainGrid(){ return mainGrid; }
    public void drawGrid(){
        //creates and draws col and row squares
        int i = 0;
        int j = 0;
        for (int sq = 0; sq < mainGrid.length; sq++){
            mainGrid[sq] = new GridRectangle(i, j);
            i++;
            if(i == cols){
                j++;
                i = 0;
            }
            if (j == rows){
                j = 0;
            }
        }
    }
}
