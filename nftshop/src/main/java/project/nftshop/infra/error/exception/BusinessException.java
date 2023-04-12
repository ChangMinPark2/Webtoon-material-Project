package project.nftshop.infra.error.exception;

import lombok.Getter;
import project.nftshop.infra.error.model.ErrorCode;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}