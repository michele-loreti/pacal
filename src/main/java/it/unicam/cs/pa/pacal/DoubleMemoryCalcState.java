package it.unicam.cs.pa.pacal;

import java.util.HashMap;
import java.util.function.Consumer;

public class DoubleMemoryCalcState extends CalcState {

    private double mem1;
    private double mem2;

    public DoubleMemoryCalcState() {
        super();
        init();
    }

    private void init() {
        mem1 = 0.0;
        mem2 = 0.0;
    }

    @Override
    public void reset() {
        this.init();
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

    @Override
    public String toString() {
        return "[ v1="+getValue1()+" , v2="+getValue2()+" , mem1="+getMemory1()+" , mem2="+getMemory2()+"]\n";
    }


}
