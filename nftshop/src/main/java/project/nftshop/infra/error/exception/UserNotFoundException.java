package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException(){super(ErrorCodeType.USER_NOT_FOUND);}
}
