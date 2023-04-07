package project.nftshop.service.model.exception;

import project.nftshop.service.model.ErrorCode;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException(){super(ErrorCode.USER_NOT_FOUND);}
}
