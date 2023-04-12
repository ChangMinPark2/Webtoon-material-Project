package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class WrongPasswordException extends BusinessException{
    public WrongPasswordException(){super(ErrorCode.WRONG_PASSWORD);}
}
