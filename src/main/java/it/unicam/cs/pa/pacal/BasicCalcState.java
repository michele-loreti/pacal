package it.unicam.cs.pa.pacal;

public class BasicCalcState {
    protected double value1;
    protected boolean status;
    private double value2;

    public BasicCalcState() {
        this.status = true;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue(double value) {
        this.value2 = value1;
        this.value1 = value;
    }

    public boolean isOn() {
        return status;
    }

    public void turnOff() {
        this.status = false;
    }

    public void reset() {
        this.value1 = 0.0;
        this.value2 = 0.0;
    }

    protected String stringOf() {
        return "value1="+getValue1()+" , value2="+getValue2();
    }

    @Override
    public String toString() {
        return "["+stringOf()+"]";
    }

}
