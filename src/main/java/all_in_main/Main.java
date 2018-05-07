package all_in_main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Main {
    final static String outputFileName = "output.txt";
    final static String inputFile = "input.txt";
    public static void main(String[] args) throws IOException {
        System.out.println("KWIK Index Production System - Version 1");

        ArrayList<String> allLines = readLines();
        circularShift(allLines);
        alphabetize(allLines);
        writeLines(allLines);
    }

    public static ArrayList<String> readLines() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = br.readLine()) != null){
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Cannot read line from file in not_all_in_main.WordList");
            e.printStackTrace();
        }
        return result;
    }

    public static void circularShift(ArrayList<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, circularShiftLine(lines.get(i)));
        }
    }

    public static String circularShiftLine(String line) {
        String[] words = line.split(" ");
        String firstWord = words[0];

        StringJoiner sj = new StringJoiner(" ");

        for (int i = 1; i < words.length; i++) {
            sj.add(words[i]);
        }

        sj.add(firstWord);
        return sj.toString();
    }

    public static void alphabetize(ArrayList<String> lines) {
        Collections.sort(lines);
    }

    public static void writeLines(ArrayList<String> lines) throws IOException {
        FileWriter fw = new FileWriter(new File(outputFileName));

        for(int i=0;i<lines.size(); i++){
            //output to console
            System.out.println(lines.get(i).toString());
            //send output to file
            fw.write(lines.get(i).toString() + "\n");
        }
        //close file writer after
        fw.close();
    }
}