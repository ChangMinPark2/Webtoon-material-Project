package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class DuplicatedProductNameException extends BusinessException{
    public DuplicatedProductNameException(){super(ErrorCodeType.DUPLICATED_PRODUCT_NAME);}
}
