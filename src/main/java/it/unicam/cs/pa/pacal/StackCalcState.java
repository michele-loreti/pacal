package it.unicam.cs.pa.pacal;

import java.util.Stack;

public class StackCalcState implements CalcState {

    private final Stack<Double> stack = new Stack<>();
    private boolean flag = true;


    @Override
    public void setValue(double value) {
        stack.push(value);
    }

    @Override
    public boolean isOn() {
        return flag;
    }

    @Override
    public void turnOff() {
        this.flag = false;
    }

    @Override
    public void reset() {
        stack.removeAllElements();
    }

    @Override
    public double getValue1() {
        if (stack.size()<1) {
            return 0.0;
        }
        return stack.get(stack.size()-1);
    }

    @Override
    public double getValue2() {
        if (stack.size()<2) {
            return 0.0;
        }
        return stack.get(stack.size()-2);
    }

    public double[] getStack() {
        double[] toReturn = new double[stack.size()];
        int counter = 0;
        for (Double v: this.stack) {
            toReturn[counter++]=v;
        }
        return toReturn;
    }

    @Override
    public void delete() {
        stack.pop();
    }
}
