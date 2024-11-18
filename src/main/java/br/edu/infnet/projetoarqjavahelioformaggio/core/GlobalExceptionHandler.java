package br.edu.infnet.projetoarqjavahelioformaggio.core;

import br.edu.infnet.projetoarqjavahelioformaggio.exceptions.CandidatoNaoEncontrado;
import br.edu.infnet.projetoarqjavahelioformaggio.exceptions.EleitorNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(); // Padrão 500 se nenhum código for fornecido
		String message = ex.getMessage();
		return new ResponseEntity<>(createErrorResponse(statusCode, message), HttpStatus.valueOf(statusCode));
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}	

	@ExceptionHandler(CandidatoNaoEncontrado.class)
	public ResponseEntity<Object> handleValidationExceptions(CandidatoNaoEncontrado ex) {
		return new ResponseEntity<>(createErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EleitorNaoEncontrado.class)
	public ResponseEntity<Object> handleValidationExceptions(EleitorNaoEncontrado ex) {
		return new ResponseEntity<>(createErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	private Map<String, Object> createErrorResponse(int statusCode, String message) {
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("status", statusCode);
		errorResponse.put("message", message);
		return errorResponse;
	}
}