package com.akiride.calculator;

import com.akiride.calculator.common.OperatorEnum;

import java.math.BigDecimal;

/**
 * 计算器接口
 */
public interface Calculator {

    void appendNum(BigDecimal nums);

    void appendOperator(OperatorEnum operator);

    void cal();

    void undo();

    void redo();
}
