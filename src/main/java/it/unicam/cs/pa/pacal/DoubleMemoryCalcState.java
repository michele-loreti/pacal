package it.unicam.cs.pa.pacal;

public class DoubleMemoryCalcState<T extends CalcState> extends WrapperCalcState<T> {

    private double mem1;
    private double mem2;

    public DoubleMemoryCalcState(T state) {
        super(state);
        this.mem1 = 0.0;
        this.mem2 = 0.0;
    }

    @Override
    protected void doReset() {
        this.mem1 = 0.0;
        this.mem2 = 0.0;
    }

    public double getMemory1() {
        return mem1;
    }

    public double getMemory2() {
        return mem2;
    }

    public void storeToMem1() {
        mem1 = getValue1();
    }

    public void storeToMem2() {
        mem2 = getValue1();
    }

    public void call1() {
        this.setValue(getMemory1());
    }

    public void call2() {
        this.setValue(getMemory2());
    }

}
