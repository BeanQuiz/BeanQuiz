package za.co.bbd.beanquizrestapi.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.exception.ErrorModel;

import java.sql.SQLException;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleInvalidRequestBody(
            MethodArgumentNotValidException methodArgumentNotValidException
    ) {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        List<ErrorModel> errorModelList = fieldErrors.stream()
                .map(fe -> {
                    ErrorModel errorModel = new ErrorModel();
                    errorModel.setCode(fe.getField());
                    errorModel.setMessage(fe.getDefaultMessage());
                    return errorModel;
                }).toList();

        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<String> handleHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException
    ) {
        return new ResponseEntity<>(httpMediaTypeNotSupportedException.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException httpMessageNotReadableException
    ) {
        return new ResponseEntity<>(httpMessageNotReadableException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), businessException.getHttpStatus());
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorModel> handleSQLException(SQLException sqlException) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("SQL_ERROR_" + sqlException.getErrorCode());
        errorModel.setMessage(sqlException.getMessage());
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

