import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    public Coin(Position position){
        super(position);
    }

    public int getCoinX(){
        return getX();
    }

    public int getCoinY(){
        return getY();
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.putString(new TerminalPosition(this.getCoinX(), this.getCoinY()), " ");
    }
}
