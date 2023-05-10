package com.akiride.calculator.log;

import java.math.BigDecimal;

public class DefaultResultLogger extends AbstractResultLogger {

    private final static String PREFIX = "结果值:";

    @Override
    public void export(BigDecimal num) {
        System.out.println(PREFIX + num.toString());
    }

}
