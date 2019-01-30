package com.wuc.store.net.exception;

/**
 * @author: wuchao
 * @date: 2018/10/29 11:26
 * @desciption: Api 异常
 */
public class ApiException extends BaseException {

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
