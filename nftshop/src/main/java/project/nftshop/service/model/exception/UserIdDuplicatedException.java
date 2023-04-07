package project.nftshop.service.model.exception;

import project.nftshop.service.model.ErrorCode;

public class UserIdDuplicatedException extends BusinessException{
    public UserIdDuplicatedException(){super(ErrorCode.USER_DUPLICATE);}
}
