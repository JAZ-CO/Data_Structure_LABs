import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Dictionary extends AVLTree<String>{

    //Using AVL Data Structure
    public Dictionary(){
        //initializing the AVL Tree with empty node
        super();
    }

    public Dictionary(String s){
        // add word method call
        try {
            addWord(s);
        }
        catch (WordAlreadyExistsException e) {
            System.out.println("WORD ALREADY EXISTED");
        }
    }

    public Dictionary(File f) throws IOException {
        // add word method call
        try {
            Scanner scan = new Scanner(f);
            System.out.println("Loading...");
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                // check if the word exist
                if (!findWord(word))
                    addWord(word);
            }
            scan.close();
            System.out.println("Dictionary with a file created successfully");
        }
        catch (Exception exception){
            System.out.println("File not Found");
            throw new IOException();
        }

    }

    //****************************************************
    // PROJECT METHODS
    public void addWord(String s) throws WordAlreadyExistsException{
        try{
            // Using AVL insert
            super.insertAVL(s);
        }
        catch (IllegalArgumentException ex){
            // throw to the main class
            throw new WordAlreadyExistsException();
        }
    }
    public boolean findWord(String s){
        // BST search
       return super.search(s);
    }
    public void removeWord(String s) throws WordNotFoundException{
        try {
            super.deleteAVL(s);
            System.out.println("word removed successfully");
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new WordNotFoundException();
        }
        catch (UnsupportedOperationException unsupportedOperationException){
            System.out.println("Dictionary is empty");
        }
    }
    public String[] findSimilar (String s){
        Stack<String> words = new Stack<>();
        if (root == null)
            return new String[]{};
        Queue<BTNode<String>> queue = new Queue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            BTNode<String> current = queue.dequeue();

            if (areWordsSimilar(s,current.data))
                words.push(current.data);

            if (current.left != null)
                queue.enqueue(current.left);
            if (current.right != null)
                queue.enqueue(current.right);

        }

        String[] similar = new String[words.size()];
        for (int i = 0; i < similar.length; i++) {
            similar[i] = words.pop();
        }
        return similar;
    }

    private static boolean areWordsSimilar(String s1, String s2){
        // check if both are the same
        if (s1.equals(s2))
            return false;

        // Check if the absolute difference in lengths is at most 1
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        // Iterate through the characters of the shorter string
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            // Check if the characters at the same position are different
            if (s1.charAt(i) != s2.charAt(i)) {
                // If the lengths are equal, check the rest of the strings
                if (s1.length() == s2.length()) {
                    return s1.substring(i + 1).equals(s2.substring(i + 1));
                }

                // If s1 is longer, check the rest of s1 starting from the next character
                if (s1.length() > s2.length()) {
                    return s1.substring(i + 1).equals(s2.substring(i));
                }

                // If s2 is longer, check the rest of s2 starting from the next character
                return s1.substring(i).equals(s2.substring(i + 1));
            }
        }
        // If we reach here, the words are similar
        return true;
    }

    public void saveWords(String s) {
        File file = new File(s);
        // using try catch because FileWriter requires it
        try {
            FileWriter fileWriter = new FileWriter(file);
            saveWords(fileWriter, super.root);
            fileWriter.close();
            System.out.println("Dictionary saved successfully.");
        }
        catch (IOException ioException){
            System.out.println("File not written successfully");
        }
    }
    private void saveWords(FileWriter file, BTNode<String> s){
        if (s == null)
            return;
        try {
            saveWords(file,s.left);
            file.write(s.data+"\n");
            saveWords(file,s.right);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
