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
        String beurt = userInteraction.askUserForAnswer("Wiens beurt is het?");
        if (beurt.equals("Mijn")){
            mijnBeurt();
        } else {
            startGuessingLoop();
        }

    }

    public void stop(){
        Logger.print("Mastermind is gestopt");
    }

    private void startGuessingLoop(){
        boolean codeIsNotGuessed = true;
        List<Guess> guesses = new ArrayList<Guess>();
        int guessId = 1;
        String secretCode = guessCode.generateCode();
        Logger.print(secretCode);
        while (codeIsNotGuessed){
            String guess = guessCode.guessCode(guesses);
            Logger.print("Mijn "+guessId+"e guess is: " + guess);
            String answerFromUser = userInteraction.generateAnswerForUser(guess, secretCode);
            Logger.print("antwoord van user is: " + answerFromUser);
            guesses.add(new Guess(guessId, guess, answerFromUser));
            codeIsNotGuessed = !answerFromUser.equals("++++");
            guessId++;
        }
        Logger.print("Je code is geraden");
    }

    private void mijnBeurt(){
        boolean codeIsNotGuessed = true;
        int guessId = 1;
        String secretCode = guessCode.generateCode();
        Logger.print(secretCode);
        while (codeIsNotGuessed){
            String guess = userInteraction.askUserForAnswer("Wat is je " + guessId + "e gok");
            String answerFromUser = userInteraction.generateAnswerForUser(guess, secretCode);
            Logger.print("antwoord van user is: " + answerFromUser);
            codeIsNotGuessed = !answerFromUser.equals("++++");
            guessId++;
        }
        Logger.print("Je hebt de code geraden, het was:" + secretCode);
    }

}