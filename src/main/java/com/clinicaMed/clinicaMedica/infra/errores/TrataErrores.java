package com.clinicaMed.clinicaMedica.infra.errores;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TrataErrores {
    //trata el error cuando la no se encuentra el id con get
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> tratarNotFound(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException err){
        List<DatosError> error=err.getFieldErrors()
                .stream()
                .map(DatosError::new)
                .toList();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ValidacionConsultaException.class)
    public ResponseEntity errorHandlerValidaciones(ValidacionConsultaException err){
        return ResponseEntity.badRequest().body(err.getMessage());
    }

    private record DatosError(String campo,String error){
        public DatosError(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }

    }
}
