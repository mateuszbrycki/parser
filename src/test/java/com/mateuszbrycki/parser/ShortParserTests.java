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
public class ShortParserTests {

    private ShortParser parser = new ShortParser();

    private String value;
    private Boolean expectedResult;

    public ShortParserTests(String value, Boolean expectedResult) {
        this.value = value;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters(name = "Run {0} expected {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "1", true} ,
                { "0", true},
                { "10", true},
                { "-10", true},
                { "-32768", true}, //+MIN_VALUE
                { "-32769", false},
                { "32767", true}, //+MAX_VALUE
                { "32768", false}
        });
    }

    @Test
    public void test() throws Exception {

        assertEquals(expectedResult, parser.isValid(value));
    }
}
