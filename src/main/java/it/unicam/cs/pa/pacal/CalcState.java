package it.unicam.cs.pa.pacal;

public class CalcState {

    private double value1;
    private double value2;
    private double mem;
    private boolean status;

    public CalcState() {
        this.status = true;
        init();
    }

    private void init() {
        this.value1 = 0.0;
        this.value2 = 0.0;
        this.mem = 0.0;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public double getMem( ) {
        return mem;
    }

    public void store() {
        this.mem = this.value1;
    }

    public void setValue(double value) {
        this.value2 = value1;
        this.value1 = value;
    }

    public void reset() {
        init();
    }

    public boolean isOn() {
        return status;
    }

    public void turnOff() {
        this.status = false;
    }

    @Override
    public String toString() {
        return "[ v1="+getValue1()+" , v2="+getValue2()+" , mem="+getMem()+"]\n";
    }
}
