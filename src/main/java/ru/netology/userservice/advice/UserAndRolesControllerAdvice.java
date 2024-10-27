package ru.netology.userservice.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.userservice.exception.NotFoundException;

@RestControllerAdvice
@Slf4j
public class UserAndRolesControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundHandler(NotFoundException exception) {
        String message = exception.getMessage();
        log.info("в процессе работы сервиса произошла ошибка: {}", message);
        return message;
    }
}
