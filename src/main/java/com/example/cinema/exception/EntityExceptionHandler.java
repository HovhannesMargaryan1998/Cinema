package com.example.cinema.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler
        extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value
//            = {Exception.class, IllegalStateException.class })
//    protected ModelAndView handleConflict(
//            RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
//        return new ModelAndView("addActor");
//    }
}
