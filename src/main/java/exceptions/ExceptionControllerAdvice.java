package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
	  // handle invalid id exception
	 @ExceptionHandler(value = ProductNotExistsException.class)
	    public final ResponseEntity<String> handleProductNotExistsException(ProductNotExistsException exception){
	        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	    }
}
