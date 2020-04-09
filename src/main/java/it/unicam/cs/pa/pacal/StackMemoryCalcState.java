package it.unicam.cs.pa.pacal;

import java.util.Stack;

public class StackMemoryCalcState<T extends CalcState> extends WrapperCalcState<T> {

    private final Stack<Double> stack;

    public StackMemoryCalcState(T state) {
        super(state);
        this.stack = new Stack<>();
    }

    @Override
    protected void doReset() {
        this.stack.removeAllElements();
    }

    public void push() {
        stack.push(getValue1());
    }

    public void pop() {
        setValue( stack.pop() );
    }

    public double[] getStack() {
        double[] toReturn = new double[stack.size()];
        int counter = 0;
        for (Double v: this.stack) {
            toReturn[counter++]=v;
        }
        return toReturn;
    }
}
