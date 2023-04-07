package project.nftshop.service.model.exception;

import project.nftshop.service.model.ErrorCode;

public class WrongCheckPasswordException extends BusinessException{
    public WrongCheckPasswordException(){super(ErrorCode.WRONG_CHECK_PASSWORD);}
}
