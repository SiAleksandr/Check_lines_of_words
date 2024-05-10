package oopVersion.application;
import java.util.List;
import oopVersion.calculations.UseCalc;

public class Output {
    public void showActions (List<UseCalc> variants) {
        for (UseCalc v: variants) {
            System.out.println(v.performance());
        }
        System.out.println("0 - Выход");
    }
    public void offer (String mes) {
        System.out.print(mes);
    }

    public void printAnswer (List<String> answer) {
        for (String item: answer) {
            System.out.println(item);
        }
        System.out.println("Нажмите ENTER");
    }
    public void printException (Exception e) {
        System.out.println(e.fillInStackTrace());
    }
}
