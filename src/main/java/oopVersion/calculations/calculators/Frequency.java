package oopVersion.calculations.calculators;

import oopVersion.calculations.Receiving;
import oopVersion.calculations.UseCalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency extends Receiving implements UseCalc {
    public Frequency(String fileName, Integer number) {
        super(fileName, number);
    }

    @Override
    public String performance() {
        return super.getNumber() +
                " - Вычислить частоту слов";
    }

    @Override
    public ArrayList<String> findOut() throws Exception {
        Map<String, Integer> original = getWordsFrequency();
        ArrayList<String> frequencyList = new ArrayList<>();
        for (var item : original.entrySet()) {
            frequencyList.add(item.getKey() + " * " + Integer.toString(item.getValue()));
        }
        return frequencyList;
    }

    public HashMap<String, Integer> getWordsFrequency() throws Exception {
        String[] wordList = gettingWords();
        HashMap<String, Integer> required = new HashMap<>();
        List<String> words = new ArrayList<>();
        words.add(wordList[0]);
        int count;
        int len;
        for (int i = 1; i < wordList.length; i++) {
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
        return required;
    }
}
