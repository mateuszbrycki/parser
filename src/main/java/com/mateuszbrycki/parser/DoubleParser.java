package com.mateuszbrycki.parser;

import java.math.BigDecimal;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
public class DoubleParser extends AbstractParser {

    public Boolean isValid(String value) {

        try {

            BigDecimal decimal = new BigDecimal(value);

            Double doubleValue = Double.valueOf(value);

            if(doubleValue.equals(Double.POSITIVE_INFINITY) || doubleValue.equals(Double.NEGATIVE_INFINITY)) {
                return false;
            }

            Boolean isDoubleValueZero = doubleValue.equals(0.) || doubleValue.equals(-0.);

            if(isDoubleValueZero && !isDecimalZero(decimal)) {
                return false;
            }

            return true;
        } catch(NumberFormatException e) {
            return false;
        }

    }

}
