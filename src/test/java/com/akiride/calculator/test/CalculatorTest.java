package com.akiride.calculator.test;

import com.akiride.calculator.Calculator;
import com.akiride.calculator.DefaultCalculatorBuilder;
import com.akiride.calculator.common.OperatorEnum;

import java.math.BigDecimal;

public class CalculatorTest {

    public static void main(String[] args) {
        // TODO if has free time update junit test demo
        Calculator simpleCalculator = DefaultCalculatorBuilder.createCalculator();
        // 4 * 5
        simpleCalculator.appendNum(new BigDecimal(4));
        simpleCalculator.appendOperator(OperatorEnum.MULTI);
        simpleCalculator.appendNum(new BigDecimal(5));
        simpleCalculator.calc();
        // 20 / 4
        simpleCalculator.appendOperator(OperatorEnum.DIVIDE);
        simpleCalculator.appendNum(new BigDecimal(4));
        simpleCalculator.calc();
        // 20
        simpleCalculator.undo();
        // 0
        simpleCalculator.undo();
        // 20
        simpleCalculator.redo();
        // 5
        simpleCalculator.redo();
    }
}
