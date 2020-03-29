/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.pacal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 *
 */
public class App {

    private Map<String, Consumer<CalcState>> commands;
    private CalcState state;

    public static final Consumer<CalcState> SUM_FUNCTION = c -> c.setValue(c.getValue2()+c.getValue1());
    public static final Consumer<CalcState> DIF_FUNCTION = c -> c.setValue(c.getValue2()-c.getValue1());
    public static final Consumer<CalcState> MUL_FUNCTION = c -> c.setValue(c.getValue2()*c.getValue1());
    public static final Consumer<CalcState> DIV_FUNCTION = c -> c.setValue(c.getValue2()/c.getValue1());

    public App( Map<String, Consumer<CalcState>> commands, CalcState state ) {
        this.commands = commands;
        this.commands.put("help",s -> printCommands());
        this.state = state;
    }

    public static void main(String[] args) throws IOException {
        createBaseCalc().start();
    }

    private void start() throws IOException {
        hello();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (state.isOn()) {
            printState();
            System.out.print(" > ");
            System.out.flush();
            String command = reader.readLine();
            processCommand(command);
        }
        printGoodbye();
    }

    private void printGoodbye() {
        System.out.println("\n\nThank you for having used our calculator!");
        System.out.println("See you next time!\n\n");
    }

    private void hello() {
        System.out.println("******************************");
        System.out.println("*         PACALC 0.1         *");
        System.out.println("******************************");

    }

    private void printCommands() {
        TreeSet<String> words = new TreeSet<>(commands.keySet());
        String[] wordsArray = words.toArray(new String[] {});
        System.out.println("Commands: "+ Arrays.toString(wordsArray));
    }

    private void processCommand(String command) {
        try {
            double value = Double.parseDouble(command);
            state.setValue(value);
        } catch (NumberFormatException e) {
            Consumer<CalcState> action = commands.get(command);
            if (action == null) {
                System.err.println("Unknown command: "+command);
            } else {
                action.accept(state);
            }
        }
    }

    public void printState() {
        System.out.println(state.toString());
    }

    public static App createBaseCalc() {
        HashMap<String,Consumer<CalcState>> commands = new HashMap<>();
        commands.put("+",SUM_FUNCTION);
        commands.put("-",DIF_FUNCTION);
        commands.put("/",DIV_FUNCTION);
        commands.put("*",MUL_FUNCTION);
        commands.put("square",App::square);//s -> App.square(s)
        commands.put("exit",CalcState::turnOff);
        commands.put("store",CalcState::store);
        commands.put("call",s -> s.setValue(s.getMem()));
        commands.put("clear",CalcState::reset);
        commands.put("delete",s -> s.setValue(0.0));
        return new App(commands,new CalcState());
    }

    public static void square( CalcState s ) {
        double value = s.getValue1();
        s.setValue(value*value);
    }
}
