package com.mateuszbrycki.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DoubleParserTests.class,
        FloatParserTests.class,
        ShortParserTests.class
})
public class ParserTestsSuite {
}
