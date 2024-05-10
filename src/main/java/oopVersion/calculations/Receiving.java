package oopVersion.calculations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Receiving {
    String fileName;
    Integer number;

    public Receiving(String fileName, Integer number) {
        this.fileName = fileName;
        this.number = number;
    }

    public String[] gettingWords() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String line;
        String wholeThing = "";
        while ((line = br.readLine()) != null) {
            if (!(line.equals(""))) {
                wholeThing += line += " ";
            }
        }
        br.close();
        String[] allWords = wholeThing.split(" ");
//        String[] verified = correct(allWords);
//        return verified;
        return allWords;
    }

//    Метод correct() уберёт пустые значения из массива,
//    возникающие из-за лишних пробелов
//    private static String[] correct (String[] startArr) {
//        List<String> helpList = new ArrayList<>();
//        for (String word : startArr) {
//            if (!(word.equals(""))) helpList.add(word);
//        }
//        String[] verified = helpList.toArray(new String[0]);
//        return verified;
//    }
    protected String getNumber () {
        return Integer.toString(this.number + 1);
    }
}
