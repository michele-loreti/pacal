package it.unicam.cs.pa.pacal;

import java.io.IOException;

/**
 * The classes implementing this interface have the responsibility of implementing I/O user interface.
 *
 */
public interface View<T extends CalcState> {

    void open(Calculator<T> calculator) throws IOException;

    void close();

}
