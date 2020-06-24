package com.jgainey.mqtttest.mqtttest;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class MyController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello-World", HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/test-connection", produces = "application/json")
    public ResponseEntity<String> testConnection(@RequestParam(value = "count", defaultValue = "1") int count){


        for(int i = 0; i< count; i++){
            //UUID
            String publisherId = UUID.randomUUID().toString();
            //Instantiate action object
            try {
                MyAction action = new MyAction(publisherId, new MqttClient("tcp://10.0.0.26:1883",publisherId));
                action.connect();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
