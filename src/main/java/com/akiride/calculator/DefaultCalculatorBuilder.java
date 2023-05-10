package com.akiride.calculator;

public final class DefaultCalculatorBuilder {

    private DefaultCalculatorBuilder() {
        throw new AssertionError();
    }

    public static Calculator createCalculator() {
        return new SimpleCalculator();
    }
}
