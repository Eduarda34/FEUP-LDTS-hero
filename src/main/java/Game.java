import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Screen screen;

    Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); //we don't need a cursor
            screen.startScreen(); //screens must be started
            screen.doResizeIfNecessary(); //resize screen if necessary
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void draw() throws IOException {
        screen.clear();
        //arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        System.out.println(key);
    }

    public void run() {
    }
}
