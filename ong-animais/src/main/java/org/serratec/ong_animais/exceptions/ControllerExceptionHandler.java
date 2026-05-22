package org.serratec.ong_animais.exceptions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResposta> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ErroResposta erro = new ErroResposta();

        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setTitulo("Recurso não encontrado");
        erro.setDataHora(LocalDateTime.now());
        erro.setErros(List.of(ex.getMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(EnumValidationException.class)
    public ResponseEntity<ErroResposta> handleEnumValidation(
            EnumValidationException ex) {

        ErroResposta erro = new ErroResposta();

        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setTitulo("Erro de enum");
        erro.setDataHora(LocalDateTime.now());
        erro.setErros(List.of(ex.getMessage()));

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErroResposta> handleDuplicateEntry(
        DuplicateEntryException ex) {

        ErroResposta erro = new ErroResposta();

        erro.setStatus(HttpStatus.CONFLICT.value());
        erro.setTitulo("Registro duplicado");
        erro.setDataHora(LocalDateTime.now());
        erro.setErros(List.of(ex.getMessage()));

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(erro);
}

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        ErroResposta erro = new ErroResposta();

        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setTitulo("JSON inválido");
        erro.setDataHora(LocalDateTime.now());
        erro.setErros(List.of("Valor inválido enviado no corpo da requisição"));

        return ResponseEntity.badRequest().body(erro);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        ErroResposta erroResposta = new ErroResposta();

        erroResposta.setStatus(HttpStatus.BAD_REQUEST.value());
        erroResposta.setTitulo("Erro de validação");
        erroResposta.setDataHora(LocalDateTime.now());
        erroResposta.setErros(erros);

        return ResponseEntity.badRequest().body(erroResposta);
    }
}