package nl.veen.game;

import nl.veen.logging.Logger;
import nl.veen.userInteraction.UserInteraction;

public class Game {
    UserInteraction userInteraction = new UserInteraction();

    public void start(){
        Logger.print("Mastermind is gestart");
        String userAnswer = userInteraction.askUserForAnswer("Wat is het antwoord op de eerste code?");
        Logger.print("Gebruiker heeft " + userAnswer + " geantwoord");

    }

    public void stop(){
        Logger.print("Mastermind is gestopt");
    }

}
