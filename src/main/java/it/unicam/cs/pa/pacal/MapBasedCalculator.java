package it.unicam.cs.pa.pacal;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * This class has the responsibility to manage commands and execute them.
 */
public class MapBasedCalculator<T extends CalcState> implements Calculator<T> {

    private final Map<String, Consumer<? super T>> commands;
    private final T state;

    public MapBasedCalculator(Map<String, Consumer<? super T>> commands, T state) {
        this.commands = commands;
        this.state = state;

    }

    @Override
    public void processCommand(String command) {
        try {
            double value = Double.parseDouble(command);
            state.setValue(value);
        } catch (NumberFormatException e) {
            Consumer<? super T> action = commands.get(command);
            if (action == null) {
                System.err.println("Unknown command: "+command);
            } else {
                action.accept(state);
            }
        }
    }

    @Override
    public boolean isOn() {
        return state.isOn();
    }

    @Override
    public Set<String> getCommandSet() {
        return commands.keySet();
    }

    @Override
    public void addCommand(String name, Consumer<? super T>  command) {
        commands.put(name,command);
    }

    @Override
    public T getState() {
        return state;
    }
}
