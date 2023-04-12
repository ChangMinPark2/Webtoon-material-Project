package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class UserIdDuplicatedException extends BusinessException{
    public UserIdDuplicatedException(){super(ErrorCode.USER_DUPLICATE);}
}
