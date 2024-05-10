package oopVersion.calculations.calculators;

import oopVersion.calculations.Receiving;
import oopVersion.calculations.UseCalc;

import java.util.ArrayList;

public class Largest extends Receiving implements UseCalc {
    public Largest(String fileName, Integer number) {
        super(fileName, number);
    }
    @Override
    public String performance() {
        return this.getNumber() +
                " - Наяти самое длинное слово";
    }

    @Override
    public ArrayList<String> findOut() throws Exception {
        return findLargest();
    }

    public ArrayList<String> findLargest() throws Exception {
        String[] allWords = gettingWords();
        String collect = allWords[0];
        int max = allWords[0].length();
        for (int i = 1; i < allWords.length; i++) {
            if (allWords[i].length() >= max) {
                collect += " " + allWords[i];
                max = allWords[i].length();
            }
        }
        ArrayList<String> foundWords = new ArrayList<>();
        foundWords.add("");
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
        foundWords.set(0, "Самые длинные слова: ");
        return foundWords;
    }
}
