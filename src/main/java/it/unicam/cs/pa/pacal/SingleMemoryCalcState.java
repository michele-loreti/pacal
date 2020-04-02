package it.unicam.cs.pa.pacal;

public class SingleMemoryCalcState extends BasicCalcState {

    private double mem;

    public SingleMemoryCalcState() {
        super();
    }

    public double getMemory( ) {
        return mem;
    }

    public void call() {
        this.setValue(this.getMemory());
    }

    public void store() {
        this.mem = this.getValue1();
    }

    public void reset() {
        super.reset();
        this.mem = 0.0;
    }

    @Override
    protected String stringOf() {
        return super.stringOf()+" , mem="+getMemory();
    }
}
