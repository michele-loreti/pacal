package it.unicam.cs.pa.pacal;

import java.util.logging.Logger;

public class BasicCalcState implements CalcState {
    private Logger logger = Logger.getLogger("it.unicam.cs.pa.pacal.CalcState");
    public static final String MESSAGE_USAGE_WHILE_OFF = "State is off! You cannot set any value!";
    private double value1;
    private boolean status;
    private double value2;

    public BasicCalcState() {
        logger.finest("Created a BasicCalcState.");
        this.status = true;
    }

    @Override
    public double getValue1() {
        logger.finest("Value1 read.");
        return value1;
    }

    @Override
    public double getValue2() {
        logger.finest("Value2 read.");
        return value2;
    }

    @Override
    public void setValue(double value) {
        logger.finest("Received value "+value);
        if (!this.status) {
            logger.severe("Illegal use of a state: used while it is off.");
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
        logger.finest("Calculator turned off.");
        this.status = false;
    }

    @Override
    public void reset() {
        logger.finest("Calculator reset.");
        this.value1 = 0.0;
        this.value2 = 0.0;
    }

    @Override
    public void delete() {
        logger.finest("Value deleted.");
        this.setValue(0.0);
    }

}
