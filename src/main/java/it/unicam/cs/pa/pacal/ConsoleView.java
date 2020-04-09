package it.unicam.cs.pa.pacal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class ConsoleView<T extends CalcState> implements View<T> {

    private final BufferedReader reader;
    private final StatePrinter<T> printer;

    public ConsoleView(StatePrinter<T> printer) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.printer = printer;
    }

    @Override
    public void open(Calculator<T> calculator) throws IOException {
        calculator.addCommand("help",s -> printCommands( calculator ));
        hello();
        while (calculator.isOn()) {
            printState(calculator);
            System.out.print(" > ");
            System.out.flush();
            String command = reader.readLine();
            calculator.processCommand(command);
        }
        printGoodbye();
    }

    private void printCommands(Calculator<T> calculator) {
        TreeSet<String> words = new TreeSet<>(calculator.getCommandSet());
        String[] wordsArray = words.toArray(new String[] {});
        System.out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hello() {
        System.out.println("******************************");
        System.out.println("*         PACALC 0.1         *");
        System.out.println("******************************");

    }

    private void printGoodbye() {
        System.out.println("\n\nThank you for having used our calculator!");
        System.out.println("See you next time!\n\n");
    }

    public void printState(Calculator<T> calculator) {
        System.out.println(printer.stringOf(calculator.getState()));
    }


}
