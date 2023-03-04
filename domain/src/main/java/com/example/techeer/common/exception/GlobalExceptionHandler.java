package com.example.techeer.common.exception;


import com.example.techeer.common.exception.global.BadRequestException;
import com.example.techeer.common.exception.global.NoDataException;
import com.example.techeer.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ExceptionHandler 어노테이션을 사용, 전역에서 Exception을 핸들링할 수 있게 처리합니다.
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequestException(BadRequestException ex) {
        // exception throw가 발생할 경우 log를 납깁니다.
        log.info("request param omission exception", ex);
        return new ErrorResponse(ex.getErrorCode());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoDataException.class)
    public ErrorResponse handleNotFoundException(NoDataException ex) {
        // exception throw가 발생할 경우 log를 납깁니다.
        log.info("not found data exception", ex);
        return new ErrorResponse(ex.getErrorCode());
    }

}
