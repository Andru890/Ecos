package com.footalentgroup.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorized(UnauthorizedException ex) {}

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorResponse unauthorized(BadCredentialsException ex) {
        return new ErrorResponse(
                "BadCredentialsException",
                "Nombre de usuario o contraseña incorrectos.",
                HttpStatus.UNAUTHORIZED.value()
        );
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
            ForbiddenException.class,
            org.springframework.security.access.AccessDeniedException.class,
    })
    public ErrorResponse forbidden(Exception ex) {
        return new ErrorResponse(
                "ForbiddenException",
                "No tienes permiso para acceder a este recurso.",
                HttpStatus.FORBIDDEN.value()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.server.ServerWebInputException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
    })
    public ErrorResponse badRequest(Exception ex) {
        return new ErrorResponse(ex, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse badRequest(MethodArgumentNotValidException ex) {
        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ErrorResponse(
                "ValidationError",
                "La solicitud contiene datos inválidos.",
                HttpStatus.BAD_REQUEST.value(),
                details
        );
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            ConflictException.class,
            DataIntegrityViolationException.class
    })
    public ErrorResponse conflict(Exception ex) {
        return new ErrorResponse(ex, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse notFound(NotFoundException ex) {
        return new ErrorResponse(ex, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse exception(Exception ex) {
        ex.printStackTrace();   // The error must be corrected
        return new ErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
