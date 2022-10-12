import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    //Attributes
    private Hero hero;
    private Screen screen;
    private Arena arena;

    //Methods
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null); //don't need a cursor
            this.screen.startScreen(); //start screen
            this.screen.doResizeIfNecessary(); //resize if needed

            Position position = new Position(10, 10);
            this.hero = new Hero(position);
            this.arena = new Arena(40, 20, hero);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        boolean playing = true;
        while(playing) {
            draw();
            arena.moveMonsters();
            draw();

            if(arena.verifyMonsterCollisions()) {
                this.screen.close();
                playing = false;
            }

            KeyStroke key = screen.readInput();
            processKey(key, playing);

            if(arena.verifyMonsterCollisions()) {
                this.screen.close();
                playing = false;
            }
        }
    }

    private void processKey(KeyStroke key, boolean playing) throws IOException {
        System.out.println(key);

        switch (key.getKeyType()) {
            case ArrowUp:
                arena.moveHero(hero.moveUp());
                break;
            case ArrowDown:
                arena.moveHero(hero.moveDown());
                break;
            case ArrowRight:
                arena.moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                arena.moveHero(hero.moveLeft());
                break;
            case Character:
                if(key.getCharacter() == 'q' || key.getCharacter() == 'Q')
                    this.screen.close();

                break;
            case EOF:
                playing = false;
                break;
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        arena.paintArena(screen.newTextGraphics());
        this.screen.refresh();
    }
}