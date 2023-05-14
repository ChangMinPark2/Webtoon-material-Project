package project.nftshop.infra.error.exception;

import project.nftshop.infra.error.model.ErrorCodeType;

public class FileProcessingException extends BusinessException{
    public FileProcessingException(){super(ErrorCodeType.FILE_ERROR);}

}
