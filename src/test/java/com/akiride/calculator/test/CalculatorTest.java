package com.akiride.calculator.test;

import com.akiride.calculator.Calculator;
import com.akiride.calculator.DefaultCalculatorBuilder;
import com.akiride.calculator.common.OperatorEnum;
import org.junit.Test;
import java.math.BigDecimal;

public class CalculatorTest {

    @Test
    public void addTest() {
        Calculator simpleCalculator = DefaultCalculatorBuilder.createCalculator();
        // 4 + 5
        simpleCalculator.appendNum(new BigDecimal(4));
        simpleCalculator.appendOperator(OperatorEnum.ADD);
        simpleCalculator.appendNum(new BigDecimal(5));
        simpleCalculator.calc();
        // 9 + 1
        simpleCalculator.appendOperator(OperatorEnum.ADD);
        simpleCalculator.appendNum(new BigDecimal(1));
        simpleCalculator.calc();
    }

    @Test
    public void subTest() {
        Calculator simpleCalculator = DefaultCalculatorBuilder.createCalculator();
        // 4 - 5
        simpleCalculator.appendNum(new BigDecimal(4));
        simpleCalculator.appendOperator(OperatorEnum.SUBTRACT);
        simpleCalculator.appendNum(new BigDecimal(5));
        simpleCalculator.calc();
        // -1 - 1
        simpleCalculator.appendOperator(OperatorEnum.SUBTRACT);
        simpleCalculator.appendNum(new BigDecimal(1));
        simpleCalculator.calc();
    }

    @Test
    public void multiTest() {
        Calculator simpleCalculator = DefaultCalculatorBuilder.createCalculator();
        // 4 * 5
        simpleCalculator.appendNum(new BigDecimal(4));
        simpleCalculator.appendOperator(OperatorEnum.MULTI);
        simpleCalculator.appendNum(new BigDecimal(5));
        simpleCalculator.calc();
        // 20 * 2
        simpleCalculator.appendOperator(OperatorEnum.MULTI);
        simpleCalculator.appendNum(new BigDecimal(2));
        simpleCalculator.calc();
        // 40 * 0
        simpleCalculator.appendOperator(OperatorEnum.MULTI);
        simpleCalculator.appendNum(new BigDecimal(0));
        simpleCalculator.calc();
    }

    @Test
    public void divideTest() {
        Calculator simpleCalculator = DefaultCalculatorBuilder.createCalculator();
        // 20 / 5
        simpleCalculator.appendNum(new BigDecimal(20));
        simpleCalculator.appendOperator(OperatorEnum.DIVIDE);
        simpleCalculator.appendNum(new BigDecimal(5));
        simpleCalculator.calc();
        // 4 / 8
        simpleCalculator.appendOperator(OperatorEnum.DIVIDE);
        simpleCalculator.appendNum(new BigDecimal(8));
        simpleCalculator.calc();
        // 0.5 / 0
        simpleCalculator.appendOperator(OperatorEnum.DIVIDE);
        simpleCalculator.appendNum(new BigDecimal(0));
        simpleCalculator.calc();
    }

    @Test
    public void undoAndRedoTest() {
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
