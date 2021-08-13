package org.academiadecodigo.maindalorians;

import org.academiadecodigo.maindalorians.Grid.MainGrid;
import org.academiadecodigo.maindalorians.Grid.Utils;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;


public class PlayerSq  implements KeyboardHandler {
    private Rectangle playerSq;
    private final int OFFSET = 1;
    private int col;
    private int row;
    private MainGrid mainGrid;

    public PlayerSq(MainGrid mainGrid){
        playerSq = new Rectangle(10 + OFFSET, 10 + OFFSET, SandPlayBox.CELSIZE - OFFSET, SandPlayBox.CELSIZE - OFFSET);
        playerSq.setColor(Color.GREEN);
        playerSq.fill();
        col = 0;
        row = 0;
        this.mainGrid = mainGrid;

    }

    public int getCol(){
        return col;
    }
    public int getRow(){ return row; }
    public void setCol(int col){ this.col += col; }
    public void setRow(int row){ this.row += row; }
    public void translate(int x, int y){
        playerSq.translate(x, y);
    }


    @Override
    public void keyPressed(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_UP:
                Utils.moveUp(this);
                break;

            case KeyboardEvent.KEY_DOWN:
                Utils.moveDown(this, mainGrid);
                break;

            case KeyboardEvent.KEY_LEFT:
                Utils.moveLeft(this);
                break;

            case KeyboardEvent.KEY_RIGHT:
                Utils.moveRight(this, mainGrid);
                break;

            case KeyboardEvent.KEY_C:
                Utils.clear(mainGrid);
                break;

            case KeyboardEvent.KEY_I:
                Utils.invert(mainGrid);
                break;

            case KeyboardEvent.KEY_SPACE:
                Utils.drawDelete(this, mainGrid);
                break;

            case KeyboardEvent.KEY_S:
                try {
                    Utils.save(mainGrid);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case KeyboardEvent.KEY_L:
                try {
                    Utils.load(mainGrid);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
