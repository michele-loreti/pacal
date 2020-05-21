package it.unicam.cs.pa.pacal;

public class BasicCalcStateController {

    private BasicCalcState state;

    public BasicCalcStateController() {
        this.state = new BasicCalcState();
    }

    public void setVaue(double v) {
        state.setValue(v);
    }

    public double getValue1() {
        return state.getValue1();
    }

    public double getValue2() {
        return state.getValue2();
    }

    public void addition() {
        state.setValue(state.getValue2()+state.getValue1());
    }

    public void subtraction() {
        state.setValue(state.getValue2()-state.getValue1());
    }

    public void multiplication() {
        state.setValue(state.getValue2()*state.getValue1());
    }

    public void division() {
        state.setValue(state.getValue2()/state.getValue1());
    }

    public void reset() {
        state.reset();
    }
}
