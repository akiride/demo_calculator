package com.akiride.calculator;

import com.akiride.calculator.common.OperatorEnum;

import java.math.BigDecimal;

public abstract class AbstractCalculator implements Calculator {

    public void appendNum(BigDecimal nums) {
        throw new UnsupportedOperationException();
    }

    public void appendOperator(OperatorEnum operator) {
        throw new UnsupportedOperationException();
    }

    public void cal() {
        throw new UnsupportedOperationException();
    }

    public void undo() {
        throw new UnsupportedOperationException();
    }

    public void redo() {
        throw new UnsupportedOperationException();
    }
}
