package net.chibidevteam.ddlmanager.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ValidationException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(final ValidationException ex,
            final WebRequest request) {
        if (ex instanceof ConstraintViolationException) {
            final String message = generateMessageFromValidationException(ex);
            return handleRestExceptionWithMessage(ex, request, HttpStatus.BAD_REQUEST, message);
        } else {
            return handleRestException(ex, request, HttpStatus.BAD_REQUEST);
        }

    }

    // @ExceptionHandler(value = { AuthenticationException.class })
    // public ResponseEntity<Object> handleAuthenticationException(final AuthenticationException ex,
    // final WebRequest request) {
    // return handleRestException(ex, request, HttpStatus.FORBIDDEN);
    // }

    private String generateMessageFromValidationException(final ValidationException ex) {
        ConstraintViolationException exception = (ConstraintViolationException) ex;
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getMessage());
        }
        return strBuilder.toString();
    }

    private ResponseEntity<Object> handleRestExceptionWithMessage(final Exception ex, final WebRequest request,
            final HttpStatus httpStatus, final String message) {
        final String path = request.getDescription(false).substring(4);

        final ApiErrorDto apiError = new ApiErrorDto(httpStatus.value(), httpStatus.getReasonPhrase(), message, path);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), httpStatus, request);
    }

    private ResponseEntity<Object> handleRestException(final Exception ex, final WebRequest request,
            final HttpStatus httpStatus) {
        final String message = ex.getLocalizedMessage() == null ? ex.getClass().getSimpleName()
                : ex.getLocalizedMessage();
        return handleRestExceptionWithMessage(ex, request, httpStatus, message);
    }
}
