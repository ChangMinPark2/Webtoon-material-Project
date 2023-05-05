package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class UserIdDuplicatedException extends BusinessException{
    public UserIdDuplicatedException(){super(ErrorCodeType.USER_DUPLICATE);}
}
