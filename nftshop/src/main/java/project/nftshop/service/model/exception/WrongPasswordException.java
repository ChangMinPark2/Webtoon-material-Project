package project.nftshop.service.model.exception;

import project.nftshop.service.model.ErrorCode;

public class WrongPasswordException extends BusinessException{
    public WrongPasswordException(){super(ErrorCode.WRONG_PASSWORD);}
}
