package it.unicam.cs.pa.pacal;

public class BasicCalcStatePrinter implements StatePrinter<BasicCalcState> {

    @Override
    public String stringOf(BasicCalcState state) {
        return "value1: "+state.getValue1()+" value2: "+state.getValue2();
    }

}
