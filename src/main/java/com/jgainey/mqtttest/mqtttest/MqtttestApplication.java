package com.jgainey.mqtttest.mqtttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqtttestApplication {

    public static void main(String[] args) {
        Utils.initLogger();
        SpringApplication.run(MqtttestApplication.class, args);
    }

}
