package com.akiride.calculator;

import com.akiride.calculator.common.OperatorEnum;
import com.akiride.calculator.log.ResultLogger;

import java.math.BigDecimal;

public abstract class AbstractCalculator implements Calculator {

    protected ResultLogger logger;

    protected AbstractCalculator(ResultLogger logger) {
        this.logger = logger;
    }

    public void appendNum(BigDecimal nums) {
        throw new UnsupportedOperationException();
    }

    public void appendOperator(OperatorEnum operator) {
        throw new UnsupportedOperationException();
    }

    public void calc() {
        throw new UnsupportedOperationException();
    }

    /**
     * 计算两个值
     * @param left
     * @param right
     * @param operator
     * @return
     */
    protected final BigDecimal calc(BigDecimal left, BigDecimal right, OperatorEnum operator) {
        if (operator == OperatorEnum.ADD) {
            return left.add(right);
        }
        if (operator == OperatorEnum.DIVIDE) {
            if (right.compareTo(BigDecimal.ZERO) == 0) {
                throw new RuntimeException("不能被0整除");
            }
            return left.divide(right);
        }
        if (operator == OperatorEnum.SUBTRACT) {
            return left.subtract(right);
        }
        if (operator == OperatorEnum.MULTI) {
            return left.multiply(right);
        }
        throw new UnsupportedOperationException("未支持计算方式");
    }

    /**
     * 执行日志输出
     * @param num
     */
    protected final void doExport(BigDecimal num) {
        this.logger.export(num);
    }

    /**
     * 输出提示
     * @param tip
     */
    protected final void doExport(String tip) {
        this.logger.export(tip);
    }

    public void undo() {
        throw new UnsupportedOperationException();
    }

    public void redo() {
        throw new UnsupportedOperationException();
    }
}
