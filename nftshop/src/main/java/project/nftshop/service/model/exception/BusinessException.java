package project.nftshop.service.model.exception;

import lombok.Getter;
import project.nftshop.service.model.ErrorCode;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}