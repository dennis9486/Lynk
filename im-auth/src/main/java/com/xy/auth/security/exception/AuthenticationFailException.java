package com.xy.auth.security.exception;

import com.xy.response.domain.ResultCode;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailException extends AuthenticationException {

    private ResultCode resultCode;

    public AuthenticationFailException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthenticationFailException(String msg) {
        super(msg);
    }

    public AuthenticationFailException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
