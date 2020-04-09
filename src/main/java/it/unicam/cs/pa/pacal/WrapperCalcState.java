package it.unicam.cs.pa.pacal;

public abstract class WrapperCalcState<T extends CalcState> implements CalcState {
    protected final T state;

    public WrapperCalcState(T state) {
        this.state = state;
    }

    @Override
    public double getValue1() {
        return state.getValue1();
    }

    @Override
    public double getValue2() {
        return state.getValue2();
    }

    @Override
    public void setValue(double value) {
        state.setValue(value);
    }

    @Override
    public boolean isOn() {
        return state.isOn();
    }

    @Override
    public void turnOff() {
        state.turnOff();
    }

    @Override
    public final void reset() {
        state.reset();
        doReset();
    }

    public T getInnerState() {
        return state;
    }

    protected abstract void doReset();

    @Override
    public void delete() {
        state.delete();
    }
}
