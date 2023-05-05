package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class WrongCheckPasswordException extends BusinessException{
    public WrongCheckPasswordException(){super(ErrorCodeType.WRONG_CHECK_PASSWORD);}
}
