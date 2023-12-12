import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();

        System.out.println("Choose one of Three options to initialize: ");
        System.out.println("1- Empty dictionary");
        System.out.println("2- Dictionary with initial String");
        System.out.println("3- Dictionary from file");

        Scanner input = new Scanner(System.in);
        String inputValue = input.next();
        // flag for second menu
        boolean flag = true;
        // initial menu
        switch(inputValue) {
            case "1":
                System.out.println("Empty dictionary created successfully");
                dict = new Dictionary();
                break;
            case "2":
                System.out.println("Enter an initial string: ");
                dict = new Dictionary(input.next());
                System.out.println("Dictionary with initial string created successfully");
                break;
            case "3":
                System.out.println("Enter a file name: ");
                try {
                    dict = new Dictionary(new File(input.next()));
                }
                catch (IOException e){
                    flag = false;
                }
                break;
            default:
                System.out.println("Please enter a number from 1-3");
        }

        if (flag) {
            System.out.println("Choose Five options to initialize: ");
            System.out.println("1- Find a word in the dictionary");
            System.out.println("2- Add a word to the dictionary");
            System.out.println("3- Remove a word to the dictionary");
            System.out.println("4- Search for similar words to a word in the dictionary");
            System.out.println("5- Save the updated dictionary as a text file");
            System.out.println("press 'q' to quit");

            inputValue = input.next();
            while (!inputValue.equals("q")) {
                switch (inputValue) {
                    case "1":
                        System.out.println("check word> ");
                        if (dict.findWord(input.next()))
                            System.out.println("word found successfully\n");
                        else
                            System.out.println("word not found\n");
                        break;
                    case "2":
                        System.out.println("add new word> ");
                        try {
                            dict.addWord(input.next());
                            System.out.println("word added successfully\n");
                        }
                        catch (WordAlreadyExistsException wordAlreadyExistsException){
                            System.out.println("WORD ALREADY EXISTED\n");
                        }
                        break;
                    case "3":
                        System.out.println("remove word> ");
                        try {
                            dict.removeWord(input.next());
                            System.out.println();
                        }
                        catch (WordNotFoundException wordNotFoundException){
                            System.out.println("word not found\n");
                        }
                        break;
                    case "4":
                        System.out.println("search for similar words> ");
                        System.out.println(Arrays.toString(dict.findSimilar(input.next()))+"\n");
                        break;
                    case "5":
                        System.out.println("Save Updated Dictionary (Y/N)> ");
                        if (input.next().equals("Y")) {
                            System.out.println("Enter Filename> ");
                            dict.saveWords(input.next());
                            System.out.println();
                        }
                        break;
                    default:
                        System.out.println("Please enter a number from 1-3");
                }
                System.out.println("Choose Five options to initialize: ");
                System.out.println("1- Find a word in the dictionary");
                System.out.println("2- Add a word to the dictionary");
                System.out.println("3- Remove a word to the dictionary");
                System.out.println("4- Search for similar words to a word in the dictionary");
                System.out.println("5- Save the updated dictionary as a text file");
                System.out.println("press 'q' to quit");
                inputValue = input.next();
            }
        }
    }
}