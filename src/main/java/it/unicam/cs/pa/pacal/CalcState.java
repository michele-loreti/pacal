package it.unicam.cs.pa.pacal;

public interface CalcState {
    double getValue1();

    double getValue2();

    void setValue(double value);

    boolean isOn();

    void turnOff();

    void reset();

    void delete();

}
