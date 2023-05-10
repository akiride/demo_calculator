package com.akiride.calculator;

import com.akiride.calculator.common.OperatorEnum;
import com.akiride.calculator.log.DefaultResultLogger;
import com.akiride.calculator.log.ResultLogger;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * 计算器实现
 */
public class SimpleCalculator extends AbstractCalculator {
    /**
     * 执行undo操作Idx limit
     */
    private static final int UNDO_LIMIT_LIMIT = 0;
    /**
     * 结果集下标初始值
     */
    private static final int IDX_INIT_VALUE = -1;
    /**
     * 之前之和
     */
    private BigDecimal preSum;
    /**
     * 当前值
     */
    private BigDecimal nowNum;
    /**
     * 当前运算符
     */
    private OperatorEnum currentOperator;
    private LinkedList<BigDecimal> resultList = new LinkedList<BigDecimal>();
    /**
     * 记录结果集的下标
     * 初始值 = -1
     */
    private int idx = IDX_INIT_VALUE;

    protected SimpleCalculator(ResultLogger logger) {
        super(logger);
    }

    protected SimpleCalculator() {
        super(new DefaultResultLogger());
    }

    @Override
    public void appendNum(BigDecimal nums) {
        if (nums == null) {
            System.out.println("设置数字为空");
            return;
        }
        if (this.preSum == null) {
            this.preSum = nums;
            return;
        }
        this.nowNum = nums;
    }

    @Override
    public void appendOperator(OperatorEnum operator) {
        if (operator == null) {
            System.out.println("设置操作符为空，请重新设置");
            return;
        }
        this.currentOperator = operator;
    }

    @Override
    public void calc() {
        // 如果前值都未设置，则进行输出计算值
        if (this.preSum == null) {
            doExport(BigDecimal.ZERO);
            return;
        }
        if (this.currentOperator == null) {
            this.currentOperator = OperatorEnum.ADD;
        }
        BigDecimal left = this.preSum;
        BigDecimal right = this.nowNum != null ? this.nowNum : BigDecimal.ZERO;
        BigDecimal result = null;
        try {
            result = calc(left, right, this.currentOperator);
            this.preSum = result;
            setResult(this.currentOperator, result);
        } catch (Exception e) {
            result = BigDecimal.ZERO;
        }
        doExport(result);
    }

    private void setResult(OperatorEnum operator, BigDecimal result) {
        this.resultList.add(result);
        this.idx ++;
        // 移除idx 之后的节点
        for (int i = idx + 1; i < resultList.size(); i ++) {
            resultList.remove(i);
        }
    }

    @Override
    public void redo() {
        if (this.idx < 0 && this.resultList.isEmpty()) {
            return;
        }
        // 如果 指针在最后一位，则用当前和输出
        if (this.idx == this.resultList.size() - 1) {
            doExport(this.preSum);
            return;
        }
        this.idx ++;
        BigDecimal nextResult = this.resultList.get(this.idx);
        this.preSum = nextResult;
        doExport(this.preSum);
    }

    @Override
    public void undo() {
        // 如果当前指针已经在 第一位，还需要undo ，则返回 0
        if (this.idx == UNDO_LIMIT_LIMIT || this.idx == IDX_INIT_VALUE) {
            // 将前值之和设置为 0 并且进行输出
            this.preSum = BigDecimal.ZERO;
            doExport(this.preSum);
            this.idx = IDX_INIT_VALUE;
            return;
        }
        // 更新下标往左移动
        this.idx --;
        //拿出上次结果集
        BigDecimal preSumTmp = this.resultList.get(this.idx);
        this.preSum = preSumTmp;
        doExport(this.preSum);
    }

}
