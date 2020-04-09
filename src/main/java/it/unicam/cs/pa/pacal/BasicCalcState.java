package it.unicam.cs.pa.pacal;

public class BasicCalcState implements CalcState {
    public static final String MESSAGE_USAGE_WHILE_OFF = "State is off! You cannot set any value!";
    private double value1;
    private boolean status;
    private double value2;

    public BasicCalcState() {
        this.status = true;
    }

    @Override
    public double getValue1() {
        return value1;
    }

    @Override
    public double getValue2() {
        return value2;
    }

    @Override
    public void setValue(double value) {
        if (!this.status) {
            throw new IllegalStateException(MESSAGE_USAGE_WHILE_OFF);
        }
        this.value2 = value1;
        this.value1 = value;
    }

    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void turnOff() {
        this.status = false;
    }

    @Override
    public void reset() {
        this.value1 = 0.0;
        this.value2 = 0.0;
    }

    @Override
    public void delete() {
        this.setValue(0.0);
    }

}
