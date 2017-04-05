package com.mateuszbrycki.parser;

import java.math.BigDecimal;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
public class ShortParser extends AbstractParser {

    public Boolean isValid(String value) {
        try {

            BigDecimal decimal = new BigDecimal(value);

            Short floatValue = Short.valueOf(value);

            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
