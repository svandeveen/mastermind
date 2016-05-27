package nl.veen;

import nl.veen.game.Game;
import nl.veen.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.print("Mastermind wordt gestart");
        Game game = new Game();
        game.start();
        Logger.print("Mastermind wordt gestopt");
        game.stop();
    }
}
