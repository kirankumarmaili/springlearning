package o.k.spring.slearn.exceptions;

import java.util.Date;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * SlearnExceptionHandler
 */
//Controller advice used to share the information across the rest controller
@ControllerAdvice
public class SlearnExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(SlearnRunTimeException.class)
	public final ResponseEntity<ExceptionResponse> handleSlearnRunTimeException(SlearnRunTimeException ex, WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), ex.getErrorCode());
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
			ResponseStatus status = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
			return new ResponseEntity<>(errorDetails, status.value());
		}
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), ErrorCode.UNKNOWN);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}