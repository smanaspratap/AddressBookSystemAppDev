package com.addressbook.exception;

import com.addressbook.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Global Exception Handler annotated with @ControllerAdvice.
 * Intercepts exceptions across the application and formats them nicely.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles validation failures (HTTP 400 Bad Request)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMesg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}