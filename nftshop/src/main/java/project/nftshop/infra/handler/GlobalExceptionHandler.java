package project.nftshop.infra.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.nftshop.infra.error.exception.BusinessException;
import project.nftshop.infra.error.model.ErrorCodeType;
import project.nftshop.infra.error.model.ResponseFormat;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BusinessException.class, RuntimeException.class})
    public ResponseEntity handlerRuntimeException(RuntimeException e){
        ResponseFormat responseFormat = ResponseFormat.fail(e.getMessage());
        return new ResponseEntity(responseFormat, HttpStatus.OK);
    }
}
