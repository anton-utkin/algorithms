package com.utkin.anton;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class InterpreterTest {
    @Test
    public void checkProgram(){
        short [] program = new short[] {299, 492, 495, 399, 492, 495, 399, 283, 279, 689, 78, 100, 000, 000, 000};
        Interpreter interpreter = new Interpreter();
        assertEquals(interpreter.execute(program), 16);
    }
}
