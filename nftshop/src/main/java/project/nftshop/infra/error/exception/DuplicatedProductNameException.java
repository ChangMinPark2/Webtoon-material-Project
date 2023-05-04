package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class DuplicatedProductNameException extends BusinessException{
    public DuplicatedProductNameException(){super(ErrorCode.DUPLICATED_PRODUCT_NAME);}
}
