package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class WrongCheckPasswordException extends BusinessException{
    public WrongCheckPasswordException(){super(ErrorCode.WRONG_CHECK_PASSWORD);}
}
