package com.home.DesignAnAlertSystem_ObserverDesign;

public class Admin implements Subscriber {
    private String adminName;

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public void receiveAlert(Alert alert) {
        System.out.println("[Admin] " + adminName + " received: " + alert.toString());
    }
}
