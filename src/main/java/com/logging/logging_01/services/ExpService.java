package com.logging.logging_01.services;
import org.springframework.stereotype.Service;

@Service
public class ExpService {

    public double power(int base, int exponent) {
        if (base > 0 && exponent > 0) {
            return Math.pow(base, exponent);
        } else throw new Error("Invalid data");
    }
}

