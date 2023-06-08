package de.docmorris.bowling;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame(true);
        frame.roll(10);
        System.out.println(frame);
        frame.roll(5);
        System.out.println(frame);
        frame.roll(5);
        System.out.println(frame);
    }
}