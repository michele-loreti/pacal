package it.unicam.cs.pa.pacal;

public class SingleMemoryCalcState<T extends CalcState> extends WrapperCalcState<T> {

    private double mem;

    public SingleMemoryCalcState(T state) {
        super(state);
    }

    @Override
    protected void doReset() {
        this.mem = 0.0;
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


}
