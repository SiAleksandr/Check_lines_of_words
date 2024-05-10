package oopVersion.calculations.calculators;

import oopVersion.calculations.Receiving;
import oopVersion.calculations.UseCalc;

import java.util.ArrayList;

public class Amount extends Receiving implements UseCalc {

    public Amount(String fileName, Integer number) {
        super(fileName, number);
    }

    @Override
    public String performance() {
        return super.getNumber() +
                " - Найти общее количество слов";

    }

    @Override
    public ArrayList<String> findOut() throws Exception {
        ArrayList<String> wordsNumber = new ArrayList<>();
        Integer num = calculateAmount();
        String number = Integer.toString(num);
        wordsNumber.add("Общее число слов " + number);
        return wordsNumber;
    }

    public Integer calculateAmount() throws Exception {
        String[] allWords = this.gettingWords();
        return allWords.length;
    }
}
