package circle_group.homeworkStudent.controller;

import circle_group.homeworkStudent.dto.ResponseDto;
import circle_group.homeworkStudent.dto.ValidatorDto;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto<List<ValidatorDto>> validatorExceptions(MethodArgumentNotValidException exception){
        List<ValidatorDto> errors = exception.getBindingResult().getFieldErrors().stream().map(fieldError -> new ValidatorDto(fieldError.getField(), fieldError.getDefaultMessage())).toList();
        return ResponseDto.<List<ValidatorDto>>builder().code(-3).success(false).message("validator error").errors(errors).build();
    }

}
