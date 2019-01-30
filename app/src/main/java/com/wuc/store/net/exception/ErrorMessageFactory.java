package com.wuc.store.net.exception;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.JsonParseException;
import com.wuc.store.R;
import com.wuc.store.common.AppApplication;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * @author: wuchao
 * @date: 2018/10/29 11:45
 * @desciption: 错误信息处理类
 */
public class ErrorMessageFactory {

    /**
     * 处理错误
     *
     * @param e
     * @return
     */
    public static BaseException handleError(Throwable e) {
        BaseException exception = new BaseException();
        if (e instanceof ApiException) {
            exception.setCode(((ApiException) e).getCode());
        } else if (e instanceof JsonParseException) {
            exception.setCode(BaseException.JSON_ERROR);
        } else if (e instanceof HttpException) {
            exception.setCode(((HttpException) e).code());
        } else if (e instanceof SocketTimeoutException) {
            exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
        } else if (e instanceof SocketException) {
        } else {
            exception.setCode(BaseException.UNKNOWN_ERROR);
        }
        exception.setDisplayMessage(create(exception.getCode()));
        return exception;
    }

    /**
     * 根据错误码 code 获取具体消息
     *
     * @param code
     * @return
     */
    private static String create(int code) {
        String errorMsg = null;
        switch (code) {
            case BaseException.HTTP_ERROR:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_http);
                break;
            case BaseException.SOCKET_TIMEOUT_ERROR:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_socket_timeout);
                break;
            case BaseException.SOCKET_ERROR:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_socket_unreachable);
                break;
            case BaseException.ERROR_HTTP_400:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_http_400);
                break;
            case BaseException.ERROR_HTTP_404:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_http_404);
                break;
            case BaseException.ERROR_HTTP_500:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_http_500);
                break;
            case ApiException.ERROR_API_SYSTEM:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_system);
                break;
            case ApiException.ERROR_API_ACCOUNT_FREEZE:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_account_freeze);
                break;
            case ApiException.ERROR_API_NO_PERMISSION:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_api_no_permission);
                break;
            case ApiException.ERROR_API_LOGIN:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_login);
                break;
            case ApiException.ERROR_TOKEN:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_token);
                break;
            default:
                errorMsg = AppApplication.getContext().getResources().getString(R.string.error_unkown);
                break;
        }
        return errorMsg;
    }

    /**
     * 显示错误信息
     *
     * @param e
     */
    public static void showErrorMessage(BaseException e) {
        ToastUtils.showShort(e.getDisplayMessage());
    }
}
