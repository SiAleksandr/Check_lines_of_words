package execution;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dataFile = "input.txt";
        Calculate calc = new Calculate();
        Integer wordsAmount;
        Integer tempStartValue = -1;
        Integer choice = tempStartValue;
        while (choice != 0) {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("\n1 - Найти общее количество слов");
            System.out.println("2 - Наяти самое длинное слово");
            System.out.println("3 - Вычислить частоту слов");
            System.out.println("0 - Выход");
            choice = tempStartValue;
            while (choice < 0 || choice > 3) {
                System.out.printf("Ваш выбор -> ");
                String data = iScanner.nextLine();
                try {
                    choice = Integer.parseInt(data);
                    if (choice < 0 || choice > 3)
                        System.out.println("Это не то, что требуется. Выберете номер действия");
                } catch (NumberFormatException e) {
                    System.out.println("Это не то, что требуется. Введите натуральное число");
                    choice = tempStartValue;
                }
            }
            try {
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        wordsAmount = calc.amountAll(dataFile);
                        System.out.println("\nСлов было " + wordsAmount);
                        break;
                    case 2:
                        List<String> largestWords;
                        largestWords = calc.largest(dataFile);
                        System.out.println("\nСамые длинные слова:");
                        System.out.print(largestWords.get(0));
                        for (int i = 1; i < largestWords.size(); i++) {
                            System.out.print(", " + largestWords.get(i));
                        }
                        System.out.print("\n");
                        break;
                    case 3:
                        Map<String, Integer> analysisResult;
                        analysisResult = calc.wordAnalysis(dataFile);
                        for (var item: analysisResult.entrySet()) {
                            System.out.printf("\n%s * %d", item.getKey(), item.getValue());
                        }
                        break;
                }
                if (choice != 0) {
                    System.out.printf("\nНажмите Enter -> ");
                    iScanner.nextLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
