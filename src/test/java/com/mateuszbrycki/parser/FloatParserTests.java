package com.mateuszbrycki.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
@RunWith(Parameterized.class)
public class FloatParserTests {

    private FloatParser parser = new FloatParser();

    private String value;
    private Boolean expectedResult;

    public FloatParserTests(String value, Boolean expectedResult) {
        this.value = value;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters(name = "Run {0} expected {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "1.", true} ,
                { "1.f", false} ,
                { "0.0", true},
                { "0.", true},
                { "10.", true},
                { "-10.", true},
                { "1.4e-45", true}, //+MIN_VALUE
                { "-1.4e-45", true}, //-MIN_VALUE
                { "1.4e-46", false},
                { "-1.4e-46", false},
                { "3.4028235e+38", true}, //+MAX_VALUE
                { "-3.4028235e+38", true}, //-MAX_VALUE
                { "3.4028235e+39", false},
                { "-3.4028235e+39", false}
        });
    }

    @Test
    public void test() throws Exception {

        assertEquals(expectedResult, parser.isValid(value));
    }
}
