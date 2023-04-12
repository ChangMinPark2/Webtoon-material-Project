package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCode;

public class DuplicatedCellphoneException extends BusinessException{
    public DuplicatedCellphoneException(){super(ErrorCode.DUPLICATED_CELLPHONE);}
}
