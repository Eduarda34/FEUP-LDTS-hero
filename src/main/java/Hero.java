import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.text.Position;
import java.awt.*;
import java.io.IOException;

public class Hero {
    //private int x;
    //private int y;
    //private Position position;

    public Hero (Position position) {
        super(position);
    }

    public Position moveUp() {
        return new Position(getX(), getY() - 1);
    }

    public Position moveDown() {
        return new Position() {getX(), getY() + 1};
    }

    public  Position moveLeft() {
        return new Position(getX() - 1, getY());
    }

    public Position moveRight() {
        return new Position(getX() + 1, getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY(), "X"));
    }
}
