package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class DuplicatedCellphoneException extends BusinessException{
    public DuplicatedCellphoneException(){super(ErrorCodeType.DUPLICATED_CELLPHONE);}
}
