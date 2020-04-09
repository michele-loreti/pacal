package it.unicam.cs.pa.pacal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalcStateTest {

    private BasicCalcState s;

    @BeforeEach
    void initCalcState() {
        this.s = new BasicCalcState();
    }

    @Test
    void setValue() {
        s.setValue(10.0);
        s.setValue(20.0);
        assertEquals(20.0,s.getValue1());
        assertEquals(10.0,s.getValue2());
    }

    @Test
    void turnOff() {
        assertTrue(s.isOn());
        s.turnOff();
        assertFalse(s.isOn());
    }

    @Test
    void shouldThrowExceptionIfOff() {
        s.turnOff();
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> s.setValue(10.0));
        assertEquals(BasicCalcState.MESSAGE_USAGE_WHILE_OFF,e.getMessage());
    }

    @Test
    void reset() {
        s.reset();
        assertEquals(0.0,s.getValue1());
        assertEquals(0.0,s.getValue2());
    }
}