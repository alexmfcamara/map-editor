package org.academiadecodigo.maindalorians.Grid;

import org.academiadecodigo.maindalorians.PlayerSq;
import org.academiadecodigo.maindalorians.SandPlayBox;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.*;

public class Utils {
    public static void clear(MainGrid mainGrid){
        GridRectangle[] rects = mainGrid.getMainGrid();
        for (int i = 0; i < rects.length; i++){
            rects[i].getMe().setColor(Color.BLACK);
            rects[i].getMe().draw();
            rects[i].setFillFalse();
        }
    }
    public static void invert(MainGrid mainGrid){
        GridRectangle[] rects = mainGrid.getMainGrid();
        for (int i = 0; i < rects.length; i++){
            if (rects[i].isFill()){
                rects[i].revertFill();
                rects[i].getMe().setColor(Color.BLACK);
                rects[i].getMe().draw();
                continue;
            }
            rects[i].revertFill();
            rects[i].getMe().setColor(Color.MAGENTA);
            rects[i].getMe().fill();
        }
    }
    public static void drawDelete(PlayerSq playerSq, MainGrid mainGrid) {
        GridRectangle[] rects = mainGrid.getMainGrid();
        for (int i = 0; i < rects.length; i++) {
            if(playerSq.getRow() == rects[i].getRow() &&
                    playerSq.getCol() == rects[i].getCol()){
                if (rects[i].isFill()){
                    rects[i].getMe().setColor(Color.BLACK);
                    rects[i].getMe().draw();
                    rects[i].revertFill();
                    continue;
                }
                rects[i].revertFill();
                rects[i].getMe().setColor(Color.MAGENTA);
                rects[i].getMe().fill();
            }
        }
    }
    public static void save(MainGrid mainGrid) throws IOException {
        GridRectangle[] rects = mainGrid.getMainGrid();
        String saveFile = "";
        for(int i = 0; i < rects.length; i++){
            if(rects[i].isFill()){
                saveFile += "1 ";
                continue;
            }
            saveFile += "0 ";
        }
        FileWriter writer = new FileWriter("grid.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write(saveFile);
        bWriter.flush();
        bWriter.close();
    }
    public static void load(MainGrid mainGrid) throws IOException {
        GridRectangle[] rects = mainGrid.getMainGrid();
        FileReader reader = new FileReader("grid.txt");
        BufferedReader bReader = new BufferedReader(reader);
        String[] saveFile = bReader.readLine().split(" ");
        bReader.close();
        for(int i = 0; i < saveFile.length; i++){
            if(saveFile[i].equals("0")){
                if(rects[i].isFill()){
                    rects[i].revertFill();
                    rects[i].getMe().setColor(Color.BLACK);
                    rects[i].getMe().draw();
                }
                continue;
            }
            if(rects[i].isFill()){
                continue;
            }
            rects[i].revertFill();
            rects[i].getMe().setColor(Color.MAGENTA);
            rects[i].getMe().fill();

        }

    }

    public static void moveUp(PlayerSq playerSq){
        if(playerSq.getRow() == 0){
            return;
        }
        playerSq.translate(0, -SandPlayBox.CELSIZE);
        playerSq.setRow(-1);
    }
    public static void moveDown(PlayerSq playerSq, MainGrid mainGrid){
        if(playerSq.getRow() == mainGrid.getRows() - 1){
            return;
        }
        playerSq.translate(0, SandPlayBox.CELSIZE);
        playerSq.setRow(1);
    }
    public static void moveLeft(PlayerSq playerSq){
        if(playerSq.getCol() == 0){
            return;
        }
        playerSq.translate(-SandPlayBox.CELSIZE, 0);
        playerSq.setCol(-1);
    }
    public static void moveRight(PlayerSq playerSq, MainGrid mainGrid){
        if(playerSq.getCol() == mainGrid.getCols() - 1){
            return;
        }
        playerSq.translate(SandPlayBox.CELSIZE, 0);
        playerSq.setCol(1);
    }
}
