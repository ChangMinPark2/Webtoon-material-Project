package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class NotFoundException extends BusinessException{
    public NotFoundException(){super(ErrorCodeType.NOT_FOUND);}
}
