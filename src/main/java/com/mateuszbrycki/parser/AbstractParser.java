package com.mateuszbrycki.parser;

import java.math.BigDecimal;

/**
 * Created by Mateusz Brycki on 05/04/2017.
 */
public abstract class AbstractParser {

    protected Boolean isDecimalZero(BigDecimal decimal) {
        return decimal.compareTo(BigDecimal.ZERO) == 0;
    }
}
