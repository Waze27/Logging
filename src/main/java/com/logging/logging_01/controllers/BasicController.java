package com.logging.logging_01.controllers;

import com.logging.logging_01.services.ExpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    Environment environment;

    @Autowired
    ExpService expService;

    @GetMapping("/")
    public String getMessage() {
        logger.info("Info message of localhost");
        return "Welcome at localhost!";
    }

    @GetMapping("/expTwo")
    public int getExpProd() {
        logger.info("Info message of services prod");
        System.out.println("The power of " + environment.getProperty("varProd.prod") + " is " + expService.powerProd());
        return expService.powerProd();
    }

    @GetMapping("/expEight")
    public int getExpTest() {
        logger.info("Info message of services test");
        System.out.println("The power of " + environment.getProperty("varTest.test") + " is " + expService.powerTest());
        return expService.powerTest();
    }

    @GetMapping("/errors")
    public void error() {
        Error error = new Error("This is an Error!");
        logger.error("This is the error logging", error);
    }


}
