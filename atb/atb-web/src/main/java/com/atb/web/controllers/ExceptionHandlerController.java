package com.atb.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController
{
    private static final Log LOG = LogFactory.getLog(ExceptionHandlerController.class);

    @SuppressWarnings("deprecation")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception e)
    {
        LOG.error("ExceptionHandlerController : Exception occured : " , e);
        return new ResponseEntity<Object>(HttpStatus.METHOD_FAILURE);

    }
}
