package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class NotFoundException extends BusinessException{
    public NotFoundException(){super(ErrorCode.NOT_FOUND);}
}
