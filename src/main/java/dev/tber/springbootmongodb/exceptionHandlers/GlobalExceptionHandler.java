package dev.tber.springbootmongodb.exceptionHandlers;
import dev.tber.springbootmongodb.exceptions.ExistingStudentException;
import dev.tber.springbootmongodb.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> handleStudentNotFoundException(StudentNotFoundException e){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("Error message",e.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExistingStudentException.class)
    public Map<String,String> handleExistingStudentException(ExistingStudentException e){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("Error message",e.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> errorMap=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(err->errorMap.put(err.getField(),err.getDefaultMessage()));
        return errorMap;
    }

}
