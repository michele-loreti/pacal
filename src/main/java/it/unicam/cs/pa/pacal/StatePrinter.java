package it.unicam.cs.pa.pacal;

import java.util.Arrays;

@FunctionalInterface
public interface StatePrinter<T extends CalcState> {

    static String stringOfStack(double[] stack) {
        return Arrays.toString(stack);
    }

    String stringOf(T state);

}
