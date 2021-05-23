package employees.b2w.digital.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import employees.b2w.digital.exception.BadRequestException;
import employees.b2w.digital.exception.ExceptionDetails;
import employees.b2w.digital.exception.RequestExceptionDetails;
import employees.b2w.digital.exception.ValidationExceptionDetails;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception e, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(status.value())
				.title(e.getCause().getMessage())
				.details(e.getMessage())
				.developerMessage(e.getClass().getName())
				.build();
				
		return new ResponseEntity<>(exceptionDetails, headers, status);
	}
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<RequestExceptionDetails> handleBadRequestException(BadRequestException e){
		return new ResponseEntity<>(
				RequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Exception, check the Documentation")
				.details(e.getMessage())
				.developerMessage(e.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST);
	}
	
		
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FieldError> fieldErros = e.getBindingResult().getFieldErrors();
		
		String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String fieldsMessage = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
		
		return new ResponseEntity<>(
				ValidationExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Exception, check the Documentation")
				.details("Check the field(s) error")
				.developerMessage(e.getClass().getName())
				.fields(fields)
				.fieldsMessage(fieldsMessage)
				.build(), HttpStatus.BAD_REQUEST);
	}
}
