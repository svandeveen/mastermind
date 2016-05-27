package nl.veen.userInteraction;

import nl.veen.logging.Logger;

import java.util.Scanner;

public class UserInteraction {
    public String askUserForAnswer(String question){
        Scanner reader = new Scanner(System.in);
        Logger.print(question + ": ");
        return reader.nextLine();
    }
}
