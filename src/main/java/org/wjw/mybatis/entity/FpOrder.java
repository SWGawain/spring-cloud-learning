package org.wjw.mybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FpOrder implements Serializable {
    private static final long serialVersionUID = -8400119726958548864L;

    public static final Integer IS_DELETE_TRUE = 1;
    public static final Integer IS_DELETE_FALSE = 0;

    public static final Integer BIZ_STATUS_NEW = 100;
    public static final Integer BIZ_STATUS_PAYSUCC = 200;
    public static final Integer BIZ_STATUS_PAYFAIL = 300;
    public static final Integer BIZ_STATUS_REPAYMENTING = 400;
    public static final Integer BIZ_STATUS_REPAYMENTED = 500;

    public static final Integer REPAYMENT_TYPE_MATURITY_PRINCIPAL_INTEREST = 1;
    public static final Integer REPAYMENT_TYPE_EQUALITY_PRINCIPAL_AND_INTEREST = 2;
    public static final Integer REPAYMENT_TYPE_EQUALITY_PRINCIPAL = 3;
    public static final Integer REPAYMENT_TYPE_INTEREST_OVER_PRINCIPAL = 4;

    public static final Integer TERM_UNIT_DAY = 1;
    public static final Integer TERM_UNIT_MONTH = 2;

    public static final Integer DATA_SOURCE_NEW = 1;

    private Long fpOrderId;

    private Long productId;

    private Long userId;

    private BigDecimal rate;

    private Integer termCount;

    private Integer termUnit;

    private BigDecimal amount;

    private BigDecimal remainAmountBak;

    private BigDecimal remainAmount;

    private Long repaymentDate;

    private Long startInterestDate;

    private Long endInterestDate;

    private Integer bizStatus;

    private Integer isDelete;

    private Integer dataSource;

    private Long createDate;

    private Long updateDate;

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getFpOrderId() {
        return fpOrderId;
    }

    public void setFpOrderId(Long fpOrderId) {
        this.fpOrderId = fpOrderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getTermCount() {
        return termCount;
    }

    public void setTermCount(Integer termCount) {
        this.termCount = termCount;
    }

    public Integer getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(Integer termUnit) {
        this.termUnit = termUnit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRemainAmountBak() {
        return remainAmountBak;
    }

    public void setRemainAmountBak(BigDecimal remainAmountBak) {
        this.remainAmountBak = remainAmountBak;
    }

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Long getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Long repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Long getStartInterestDate() {
        return startInterestDate;
    }

    public void setStartInterestDate(Long startInterestDate) {
        this.startInterestDate = startInterestDate;
    }

    public Long getEndInterestDate() {
        return endInterestDate;
    }

    public void setEndInterestDate(Long endInterestDate) {
        this.endInterestDate = endInterestDate;
    }

    public Integer getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(Integer bizStatus) {
        this.bizStatus = bizStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "FpOrder{" +
                "fpOrderId=" + fpOrderId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", rate=" + rate +
                ", termCount=" + termCount +
                ", termUnit=" + termUnit +
                ", amount=" + amount +
                ", remainAmountBak=" + remainAmountBak +
                ", remainAmount=" + remainAmount +
                ", repaymentDate=" + repaymentDate +
                ", startInterestDate=" + startInterestDate +
                ", endInterestDate=" + endInterestDate +
                ", bizStatus=" + bizStatus +
                ", isDelete=" + isDelete +
                ", dataSource=" + dataSource +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}