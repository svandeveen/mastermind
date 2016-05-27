package nl.veen.userInteraction;

import nl.veen.logging.Logger;

import java.util.*;

public class UserInteraction {
    public String askUserForAnswer(String question){
        Scanner reader = new Scanner(System.in);
        Logger.print(question + ": ");
        return reader.nextLine();
    }

    public String generateAnswerForUser(String code, String secretCode){
        return determinePlussesAndMinusses(code, secretCode);
    }

    private String determinePlussesAndMinusses(String code, String secretCode){
        String answer = "";
        int i = 0;
        List secretCodeList = getSecretCodeList(secretCode);
        for (char letter: code.toCharArray()) {
            if (letter == secretCode.charAt(i)){
                answer += "+";
                secretCodeList.remove(new Character(letter));
            }
            i++;
        }
        for (char letter: code.toCharArray()) {
            if (secretCode.contains(letter+"") && secretCodeList.contains(letter)){
                answer += "-";
                secretCodeList.remove(new Character(letter));
            }
        }
        return answer.equals("") ? "Niks is goed" : answer;
    }

    private List<Character> getSecretCodeList(String secretCode){
        List<Character> list = new ArrayList<Character>();
        for (char letter: secretCode.toCharArray()) {
            list.add(letter);
        }
        return list;
    }


}
