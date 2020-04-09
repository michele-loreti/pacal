package it.unicam.cs.pa.pacal;

public class SingleMemoryCalcStatePrinter<T extends CalcState> implements StatePrinter<SingleMemoryCalcState<T>> {

    private final StatePrinter<T> printer;

    public SingleMemoryCalcStatePrinter(StatePrinter<T> printer) {
        this.printer = printer;
    }

    @Override
    public String stringOf(SingleMemoryCalcState<T> state) {
        return printer.stringOf(state.getInnerState())+" mem: "+state.getMemory();
    }
}
