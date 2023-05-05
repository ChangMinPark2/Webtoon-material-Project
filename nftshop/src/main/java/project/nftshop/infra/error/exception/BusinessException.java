package project.nftshop.infra.error.exception;

import lombok.Getter;
import project.nftshop.infra.error.model.ErrorCodeType;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorCodeType errorCodeType;

    public BusinessException(ErrorCodeType errorCodeType) {
        super(errorCodeType.getMessage());
        this.errorCodeType = errorCodeType;
    }
}