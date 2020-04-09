package it.unicam.cs.pa.pacal;

public class StackMemoryCalcStatePrinter<T extends CalcState> implements StatePrinter<StackMemoryCalcState<T>> {

    private final StatePrinter<T> printer;

    public StackMemoryCalcStatePrinter(StatePrinter<T> printer) {
        this.printer = printer;
    }

    @Override
    public String stringOf(StackMemoryCalcState<T> state) {
        return printer.stringOf(state.getInnerState())+" mem: "+StatePrinter.stringOfStack(state.getStack());
    }
}
