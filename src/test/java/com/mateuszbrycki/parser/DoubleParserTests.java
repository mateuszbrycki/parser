package com.mateuszbrycki.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
@RunWith(Parameterized.class)
public class DoubleParserTests {

    private DoubleParser parser = new DoubleParser();

    private String value;
    private Boolean expectedResult;

    public DoubleParserTests(String value, Boolean expectedResult) {
        this.value = value;
        this.expectedResult = expectedResult;
    }


    @Parameters(name = "Run {0} expected {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "1.", true} ,
                { "1.D", false} ,
                { "0.0", true},
                { "0.", true},
                { "10.", true},
                { "-10.", true},
                { "4.9E-324", true}, //+MIN_VALUE
                { "-4.9E-324", true}, //-MIN_VALUE
                { "4.9E-325", false},
                { "-4.9E-325", false},
                { "1.7976931348623157E308", true}, //+MAX_VALUE
                { "-1.7976931348623157E308", true}, //-MAX_VALUE
                { "1.7976931348623157E309", false},
                { "-1.7976931348623157E309", false}
        });
    }

    @Test
    public void test() throws Exception {

        assertEquals(expectedResult, parser.isValid(value));
    }
}
