package com.fakeTwit.controller;

import com.fakeTwit.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class ExceptionHandler {
    protected Logger logger;

    public ExceptionHandler() {
        logger = LoggerFactory.getLogger(getClass());
    }
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {

        logger.error("Request raised a DataIntegrityViolationException ");
        // Nothing to do
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    HttpStatus
    handleBadRequest(HttpServletRequest req, Exception ex) {
        return HttpStatus.BAD_REQUEST;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseBody
    String
    handleCustomRequets(HttpServletRequest req, Exception ex) {
        ex.printStackTrace();
        return ex.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    String
    handleGeneralException(HttpServletRequest req, Exception ex) {
        ex.printStackTrace();
        return ex.getMessage();
    }
}
