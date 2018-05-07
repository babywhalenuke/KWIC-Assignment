import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class WordList {
    LinkedHashSet<Line> list;

    public void loadFile(File inputFile){
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line = "";
            while((line = br.readLine()) != null){
                Line fileLine = new Line();
                String[] words = line.split(",");
                for(int i = 0 ; i < words.length; i++){
                    fileLine.add(words[i]);
                }
                list.add(fileLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Cannot read line from file in WordList");
            e.printStackTrace();
        }
    }

    public LinkedList<Object> getLineAtIndex(int index){
        int counter = 0;
        Iterator iterator = list.iterator();
        if(index < list.size()){
            while(iterator.hasNext()){
                if(counter == index){
                    return (LinkedList<Object>) iterator.next();
                }
                counter++;
            }
        }
        return null;
    }


}

