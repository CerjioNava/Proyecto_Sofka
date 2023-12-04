package EPA.Cuenta_Bancaria_Web.Exception;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler
{
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request)
    {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("Detalle de Validaciones", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolation(ConstraintViolationException ex, HttpServletRequest request)
    {
        List<String> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(error -> errors.add(error.getMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("Detalle de Validaciones", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
*/
}
