package com.akiride.calculator;

import com.akiride.calculator.common.OperatorEnum;

import java.math.BigDecimal;

/**
 * 计算器接口
 */
public interface Calculator {
    /**
     * 添加数字
     * @param nums
     */
    void appendNum(BigDecimal nums);
    /**
     * 添加操作符
     * @param operator
     */
    void appendOperator(OperatorEnum operator);
    /**
     * 计算结果
     */
    void calc();
    /**
     * 回撤到上一步计算结果
     */
    void undo();
    /**
     * 恢复到下一步计算结果
     */
    void redo();
}
