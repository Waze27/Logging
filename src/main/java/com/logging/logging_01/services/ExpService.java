package com.logging.logging_01.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ExpService {

    @Autowired
    Environment environment;

    Logger logger = LoggerFactory.getLogger(ExpService.class);


    public int powerProd() {
        try {
            logger.info("Start calculation");
            return 4;
        } finally {
            logger.info("End calculation");
        }
    }

    public int powerTest() {
        try {
            logger.info("Start calculation");
            return 16;
        } finally {
            logger.info("End calculation");
        }
    }


}
