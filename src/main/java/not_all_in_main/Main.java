package not_all_in_main;

import java.io.*;
import java.util.LinkedList;

public class Main {
    final static String inputFile = "input.txt";
    public static void main(String[] args) throws IOException {
        LinkedList<String> lines = new LinkedList<String>();
        createInputFile();

        WordList wordList = new WordList();
        File inputFile = getInputFile();
        wordList.loadFile(inputFile);


    }

    public static void createInputFile() throws IOException {
        if(new File(inputFile).exists()){
            System.out.println("File exists. Not creating");
        }
        else{
            File file = new File(inputFile);
            FileWriter fw = new FileWriter(new File("input.txt"));
            fw.write("Sometimes I go to the store. \n");
            fw.write("Other times I do not \n");
            fw.write("And these are not in order. \n");
            fw.close();
        }
    }

    public static File getInputFile(){
        return new File(inputFile);
    }




}
