package org.academiadecodigo.maindalorians.Grid;

import org.academiadecodigo.maindalorians.SandPlayBox;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridRectangle {
    private Rectangle me;
    private int col;
    private int row;
    private boolean fill;

    public GridRectangle(int x, int y){
        col = x;
        row = y;
        fill = false;
        me = new Rectangle(colToPx(x), rowToPx(y), SandPlayBox.CELSIZE, SandPlayBox.CELSIZE);
        me.draw();
    }

    public Rectangle getMe(){
        return me;
    }

    public boolean isFill() {
        return fill;
    }

    public void revertFill(){
        fill = !fill;
    }

    public void setFillFalse(){
        fill = false;
    }
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int rowToPx(int rows){
        return rows * SandPlayBox.CELSIZE + SandPlayBox.PADDING;
    }
    public int colToPx(int cols){
        return cols * SandPlayBox.CELSIZE + SandPlayBox.PADDING;
    }

}
