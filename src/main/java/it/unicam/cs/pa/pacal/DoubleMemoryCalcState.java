package it.unicam.cs.pa.pacal;

public class DoubleMemoryCalcState extends BasicCalcState {

    private double mem1;
    private double mem2;

    public DoubleMemoryCalcState() {
        super();
    }

    @Override
    public void reset() {
        super.reset();
        mem1 = 0.0;
        mem2 = 0.0;
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

    @Override
    protected String stringOf() {
        return super.stringOf()+" , mem1="+getMemory1()+" , mem2="+getMemory2();
    }
}
