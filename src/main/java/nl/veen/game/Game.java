package nl.veen.game;

import nl.veen.logging.Logger;
import nl.veen.strategy.Guess;
import nl.veen.strategy.GuessCode;
import nl.veen.userInteraction.UserInteraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private UserInteraction userInteraction = new UserInteraction();
    private GuessCode guessCode = new GuessCode();

    public void start(){
        Logger.print("Mastermind is gestart");
        startGuessingLoop();
    }

    public void stop(){
        Logger.print("Mastermind is gestopt");
    }

    private void startGuessingLoop(){
        boolean codeIsNotGuessed = true;

        List<Guess> guesses = new ArrayList<Guess>();
        int guessId = 1;
        while (codeIsNotGuessed){
            String guess = guessCode.guessCode(guessId, guesses);
            Logger.print("Mijn "+guessId+"e guess is: " + guess);
            String answerFromUser = userInteraction.askUserForAnswer("Hoe is mijn guess?");
            guesses.add(new Guess(guessId, guess, answerFromUser));
            codeIsNotGuessed = !answerFromUser.equals("++++");
            guessId++;
        }
        Logger.print("Je code is geraden");
    }

}