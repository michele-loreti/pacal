package it.unicam.cs.pa.pacal;

import java.util.Set;
import java.util.function.Consumer;

public interface Calculator<T extends CalcState> {

    void processCommand(String command);

    boolean isOn();

    Set<String> getCommandSet();

    void addCommand(String name, Consumer<? super T> command);

    T getState();
}
