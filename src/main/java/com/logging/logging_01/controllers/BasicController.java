package com.logging.logging_01.controllers;

import com.logging.logging_01.services.ExpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Value("${firstValue}")
    private String firstValue;

    @Value("${secondValue}")
    private String secondValue;

    @Autowired
    ExpService expService;

    @GetMapping("/")
    public String getMessage() {
        logger.info("Info message of localhost");
        return "Welcome at localhost!";
    }

    @GetMapping("/exp")
    public double powerMethod() {
        logger.info("Info message of services prod");
        int first = Integer.parseInt(firstValue);
        int second = Integer.parseInt(secondValue);
        logger.info("Calling service of power: (" + firstValue + ", " + secondValue + ")");
        double result = expService.power(first, second);
        logger.info("Result: " + result);
        return result;
    }

    @GetMapping("/errors")
    public void error() {
        Error error = new Error("This is an Error!");
        logger.error("This is the error logging", error);
    }
}
