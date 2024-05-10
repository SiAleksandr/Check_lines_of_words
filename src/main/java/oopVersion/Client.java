package oopVersion;

import oopVersion.application.Controller;

import java.util.Scanner;

public class Client {
    String fileName;
    public Client (String fileName) {
        this.fileName = fileName;
    }
    public void run () {
        Controller important = new Controller(this);
        important.conduct();
    }
    public String getData () {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public String getFileName () {
        return this.fileName;
    }
}
