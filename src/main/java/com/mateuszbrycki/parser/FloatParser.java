package com.mateuszbrycki.parser;

import java.math.BigDecimal;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
public class FloatParser extends AbstractParser {

    public Boolean isValid(String value) {
        try {

            BigDecimal decimal = new BigDecimal(value);

            Float floatValue = Float.valueOf(value);

            if(floatValue.equals(Float.POSITIVE_INFINITY) || floatValue.equals(Float.NEGATIVE_INFINITY)) {
                return false;
            }

            Boolean isDoubleValueZero = floatValue.equals(0.f) || floatValue.equals(-0.f);

            if(isDoubleValueZero && !isDecimalZero(decimal)) {
                return false;
            }

            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
