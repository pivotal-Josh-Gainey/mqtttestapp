package com.jgainey.mqtttest.mqtttest;


import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MyAction {

    String publisherId;
    IMqttClient publisher;

    public MyAction(String publisherId, IMqttClient publisher) {
        this.publisherId = publisherId;
        this.publisher = publisher;
    }


    public void connect() throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName("a");
        options.setPassword("a".toCharArray());
        publisher.connect(options);
    }


}
