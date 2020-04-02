package it.unicam.cs.pa.pacal;

import java.util.LinkedList;
import java.util.Stack;

public class StackMemoryState extends BasicCalcState {

    private Stack<Double> stack;

    public StackMemoryState() {
        super();
        this.stack = new Stack<>();
    }

    @Override
    protected String stringOf() {
        return super.stringOf()+" mem="+stringOfStack();
    }

    private String stringOfStack() {
        StringBuilder toReturn = new StringBuilder("@");
        for( double v: this.stack) {
            toReturn.insert(0, v + "::");
        }
        return toReturn.toString();
    }

    public void push() {
        stack.push(getValue1());
    }

    public void pop() {
        setValue( stack.pop() );
    }

    @Override
    public void reset() {
        super.reset();
        this.stack = new Stack<>();
    }




}
