package nl.veen.strategy;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessCode {
    private static ArrayList<String> POSIBLE_LETTERS = new ArrayList<String>();

    public GuessCode(){
        POSIBLE_LETTERS.add("A");
        POSIBLE_LETTERS.add("B");
        POSIBLE_LETTERS.add("C");
        POSIBLE_LETTERS.add("D");
        POSIBLE_LETTERS.add("E");
        POSIBLE_LETTERS.add("F");
    }

    public String guessCode(List<Guess> guesses){
        if (guesses.size() == 0){
            return "AABB";
        } else {
            return generateCode(guesses);
        }
    }

    public String generateCode(){
        String firstLetter = getRandomLetter();
        String secondLetter = getRandomLetter();
        String thirdLetter = getRandomLetter();
        String fourthLetter = getRandomLetter();
        return firstLetter+secondLetter+thirdLetter+fourthLetter;
    }

    private String generateCode(List<Guess> guesses){
        for (Guess guess : guesses){
            analyzeGuess(guess);
        }
        return generateCode();
    }

    private void analyzeGuess(Guess guess){
        if (guess.getAnswer().equals("")){
            dontUseAnyOfTheseChar(guess.getCode());
        }
    }

    private void dontUseAnyOfTheseChar(String code){
        for (char letter : code.toCharArray()){
            POSIBLE_LETTERS.remove(letter+"");
        }
    }

    private String getRandomLetter(){
        Random rand = new Random();
        return POSIBLE_LETTERS.get(rand.nextInt(POSIBLE_LETTERS.size()));
    }
}
