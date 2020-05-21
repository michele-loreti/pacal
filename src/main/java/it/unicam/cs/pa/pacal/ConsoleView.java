package it.unicam.cs.pa.pacal;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class ConsoleView<T extends CalcState> implements View<T> {

    private final BufferedReader in;
    private final PrintStream out;
    private final PrintStream err;
    private final StatePrinter<T> printer;

    public ConsoleView(InputStream is, OutputStream os, StatePrinter<T> printer) {
        this(new BufferedReader(new InputStreamReader(is)),new PrintStream(os),printer);
    }

    public ConsoleView(BufferedReader in, PrintStream out, StatePrinter<T> printer) {
        this(in,out,out,printer);
    }

    public ConsoleView(BufferedReader in, PrintStream out, PrintStream err, StatePrinter<T> printer) {
        this.out = out;
        this.in = in;
        this.printer = printer;
        this.err = err;
    }

    public ConsoleView(StatePrinter<T> printer) {
        this(new BufferedReader(new InputStreamReader(System.in)),System.out,System.err,printer);
    }

    @Override
    public void open(Calculator<T> calculator) throws IOException {
        calculator.addCommand("help",s -> printCommands( calculator ));
        hello();
        while (calculator.isOn()) {
            printState(calculator);
            out.print(" > ");
            out.flush();
            String command = in.readLine();
            try {
                calculator.processCommand(command);
            } catch (UnknownCommandException e) {
                this.showErrorMessage("Unknown command "+e.getCommand());
            }
        }
        printGoodbye();
    }

    private void printCommands(Calculator<T> calculator) {
        TreeSet<String> words = new TreeSet<>(calculator.getCommandSet());
        String[] wordsArray = words.toArray(new String[] {});
        out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    @Override
    public void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showErrorMessage(String s) {
        this.err.println(s);
    }

    private void hello() {
        out.println("******************************");
        out.println("*         PACALC 0.1         *");
        out.println("******************************");

    }

    private void printGoodbye() {
        out.println("\n\nThank you for having used our calculator!");
        out.println("See you next time!\n\n");
    }

    public void printState(Calculator<T> calculator) {
        out.println(printer.stringOf(calculator.getState()));
    }


}
