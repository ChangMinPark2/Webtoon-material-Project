package project.nftshop.service.model.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.nftshop.service.model.exception.BusinessException;
import project.nftshop.service.model.ResponseFormat;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BusinessException.class, RuntimeException.class})
    public ResponseEntity handlerRuntimeException(RuntimeException e){
        ResponseFormat responseFormat = ResponseFormat.fail(e.getMessage());
        return new ResponseEntity(responseFormat, HttpStatus.OK);
    }
}
