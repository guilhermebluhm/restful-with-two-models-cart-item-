package br.twoModels.projectRelationshipTwoModels.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ObjectErrorNotFoundHandler {

    @ExceptionHandler(ObjectNotFoundInSearch.class)
    public ResponseEntity<FieldForHandlerError> objectErrorNotFoundHandler(ObjectNotFoundInSearch e,
                                                                           HttpServletRequest req){
        FieldForHandlerError err = new FieldForHandlerError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
