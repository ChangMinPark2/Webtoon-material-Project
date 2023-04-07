package project.nftshop.service.model.exception;

import project.nftshop.service.model.ErrorCode;

public class DuplicatedCellphoneException extends BusinessException{
    public DuplicatedCellphoneException(){super(ErrorCode.DUPLICATED_CELLPHONE);}
}
