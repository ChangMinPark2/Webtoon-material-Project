package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException(){super(ErrorCode.USER_NOT_FOUND);}
}
