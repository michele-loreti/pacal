package it.unicam.cs.pa.pacal;

public class StackCalcStatePrinter implements StatePrinter<StackCalcState> {

    @Override
    public String stringOf(StackCalcState state) {
        return "values: "+StatePrinter.stringOfStack(state.getStack());
    }

}
