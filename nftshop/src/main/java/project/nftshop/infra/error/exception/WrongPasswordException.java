package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class WrongPasswordException extends BusinessException{
    public WrongPasswordException(){super(ErrorCodeType.WRONG_PASSWORD);}
}
