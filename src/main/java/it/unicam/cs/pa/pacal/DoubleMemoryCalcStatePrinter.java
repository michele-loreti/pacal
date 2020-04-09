package it.unicam.cs.pa.pacal;

public class DoubleMemoryCalcStatePrinter<T extends CalcState> implements StatePrinter<DoubleMemoryCalcState<T>> {

    private final StatePrinter<T> printer;

    public DoubleMemoryCalcStatePrinter(StatePrinter<T> printer) {
        this.printer = printer;
    }

    @Override
    public String stringOf(DoubleMemoryCalcState<T> state) {
        return printer.stringOf(state.getInnerState())+" mem1: "+state.getMemory1()+" mem2: "+state.getMemory2();
    }
}
