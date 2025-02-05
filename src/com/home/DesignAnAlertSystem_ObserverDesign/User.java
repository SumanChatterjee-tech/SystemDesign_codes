package com.home.DesignAnAlertSystem_ObserverDesign;

public class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println(name + " received: " + alert.toString());
    }
}
