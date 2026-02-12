package com.douyinpay.exception;

/**
 * 抖音支付异常基类
 */
public class DouyinpayException extends RuntimeException {


    private static final long serialVersionUID = -5907864532585840242L;

    public DouyinpayException(String message) {
        super(message);
    }

    public DouyinpayException(String message, Throwable cause) {
        super(message, cause);
    }

}
