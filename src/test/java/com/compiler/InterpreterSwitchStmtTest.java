package com.compiler;

import org.junit.Test;

public class InterpreterSwitchStmtTest extends InterpreterTestBase{
    @Test
    public void testSwitchProgram01() throws Exception {
        String program = """
                {
                  DECLARE in;
                  DECLARE out;
                  in = 2;
                  out = 0;
                  SWITCH(in) {
                  CASE 1:
                    out = 2;
                  CASE 2:
                    out = 3;
                  }
                  PRINT out;
                }
                """;
        testInterpreter(program, "3\n");
    }


    @Test
    public void testSwitchProgram02() throws Exception {
        String program = """
                {
                    DECLARE in;
                    DECLARE out;
                    in = 3;
                    out = 0;
                    SWITCH(in) {
                    CASE 1:
                      out = 2;
                    CASE 2:
                      out = 3;
                    CASE 4:
                      out = 3;
                    CASE 3:
                      out = 5;
                    CASE 5:
                      out = 2;
                    }
                    PRINT out;
                  }
                """;
        testInterpreter(program, "5\n");
    }


    @Test
    public void testSwitchProgram03() throws Exception {
        String program = """
                {
                    DECLARE in;
                    DECLARE out;
                    in = 3;
                    out = 0;
                    SWITCH(in + 1) {
                    CASE 1:
                      out = 2;
                    CASE 2:
                      out = 3;
                    CASE 4:
                      out = 3;
                      in = 4;
                    CASE 3:
                      out = 5;
                    CASE 5:
                      out = 2;
                    }
                    PRINT in;
                    PRINT out;
                }
                """;
        testInterpreter(program, "4\n3\n");
    }
}
