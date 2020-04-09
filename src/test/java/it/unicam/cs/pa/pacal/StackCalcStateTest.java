package it.unicam.cs.pa.pacal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackCalcStateTest {

    @Test
    void setValue() {
        StackCalcState scs = new StackCalcState();
        scs.setValue(10.0);
        scs.setValue(20.0);
        assertEquals(20.0,scs.getValue1());
    }


}