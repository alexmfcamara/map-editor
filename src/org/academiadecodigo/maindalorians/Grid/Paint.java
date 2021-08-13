package org.academiadecodigo.maindalorians.Grid;

import org.academiadecodigo.maindalorians.PlayerSq;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Paint {
    private PlayerSq pl1;


    public void PaintExe() {
        MainGrid mainGrid = new MainGrid(20,20);
        mainGrid.drawGrid();
        pl1 = new PlayerSq(mainGrid);

        Keyboard keyboard = new Keyboard(pl1);
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent space = new KeyboardEvent();
        KeyboardEvent c = new KeyboardEvent();
        KeyboardEvent i = new KeyboardEvent();
        KeyboardEvent s = new KeyboardEvent();
        KeyboardEvent l = new KeyboardEvent();

        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
        c.setKey(KeyboardEvent.KEY_C);
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(c);
        i.setKey(KeyboardEvent.KEY_I);
        i.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(i);
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(s);
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(l);

    }
}
