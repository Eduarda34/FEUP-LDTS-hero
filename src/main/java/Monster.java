import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {
    public Monster(Position position){
        super(position);
    }

    public Position moveUp() {
        return new Position(getX(), getY() - 1);
    }

    public Position moveDown(){
        return new Position(getX(), getY() + 1);
    }
    public Position moveLeft(){
        return new Position(getX() - 1, getY());
    }
    public Position moveRight(){
        return new Position(getX() +1, getY());
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#006633"));
        graphics.putString(new TerminalPosition(getX(), this.getY()), "O");
    }
}
