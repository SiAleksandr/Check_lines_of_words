package oopVersion.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oopVersion.Client;
import oopVersion.calculations.calculators.*;
import oopVersion.calculations.UseCalc;

public class Controller {
    static Output output;
    private Client client;

    {
        output = new Output();
    }

    private String fileName;

    public Controller(Client client) {
        this.client = client;
        this.fileName = this.client.getFileName();
    }

    private ArrayList<UseCalc> createActions() {
        ArrayList<UseCalc> actions = new ArrayList<>();
        String fileName = this.client.getFileName();
        Integer index = 0;
        actions.add(new Amount(fileName, index));
        actions.add(new Largest(fileName, index += 1));
        actions.add(new Frequency(fileName, index += 1));
        return actions;
    }

    private Integer getChoice(int len) {
        Integer choiceNum = -1;
        while (choiceNum < 0 || choiceNum > len) {
            try {
                output.offer("Ваш выбор -> ");
                String choice = client.getData();
                choiceNum = Integer.parseInt(choice);
                if (choiceNum < 0 || choiceNum > len) {
                    output.offer("Это не то, что требуется. Выберете номер действия\n");
                }
            } catch (NumberFormatException e) {
                output.offer("Это не то, что требуется. Введите натуральное число\n");
                choiceNum = -1;
            }
        }
        return choiceNum;
    }

    public void conduct() {
        boolean flag = true;
        while (flag) {
            List<UseCalc> actions = this.createActions();
            output.showActions(actions);
            Integer choice = this.getChoice(actions.size());
            if (choice == 0) flag = false;
            else {
                output.offer("\n");
                choice -= 1;
                try {
                    List<String> answer = actions.get(choice).findOut();
                    output.printAnswer(answer);
                    client.getData();
                } catch (Exception e) {
                    output.printException(e);
                }
            }
        }

    }
}
