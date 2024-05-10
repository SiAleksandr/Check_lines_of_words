package execution;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculate {
    private static String[] getWords(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String str;
        str = br.readLine(); // В файле input.txt первая строка со словами и плюс две пустые
        br.close();
        String[] wordsLine = str.split(" ");
        return wordsLine;
    }

    public Integer amountAll(String fileName) throws Exception {
        String[] words = getWords(fileName);
        return words.length;
    }

    public ArrayList<String> largest(String fileName) throws Exception {
        String[] allWords = getWords(fileName);
        String collect = allWords[0];
        int max = allWords[0].length();
        for (int i = 1; i < allWords.length; i++) {
            if (allWords[i].length() >= max) {
                collect += " " + allWords[i];
                max = allWords[i].length();
            }
        }
        ArrayList<String> foundWords = new ArrayList<>();
        String[] tempArr = collect.split(" ");
        int j = tempArr.length - 1;
        String largest = tempArr[j];
        foundWords.add(largest);
        int count;
        while (j >= 0) {
            if (tempArr[j].length() == max) {
                int len = foundWords.size();
                count = 0;
                for (int w = 0; w < len; w++) {
                    if (foundWords.get(w).equals(tempArr[j])) {
                        count++;
                        w = len;
                    }
                }
                if (count == 0) {
                    foundWords.add(tempArr[j]);
                }
            }
            j--;
        }
        return foundWords;
    }

    public HashMap<String, Integer> wordAnalysis(String fileName) throws Exception {
        String[] wordList = getWords(fileName);
        HashMap<String, Integer> required = new HashMap<>();
        List<String> words = new ArrayList<>();
        words.add(wordList[0]);
        int count;
        int len;
        for (int i = 1; i < wordList.length; i++) {
            if (wordList[i].equals("")) {
            } else {
                required.putIfAbsent(wordList[i], 1);
                len = words.size();
                count = 0;
                for (int w = 0; w < len; w++) {
                    if (words.get(w).equals(wordList[i])) {
                        required.put(words.get(w), required.get(words.get(w)) + 1);
                        count += 1;
                    }
                }
                if (count == 0) words.add(wordList[i]);
            }
        }
        return required;
    }
}
