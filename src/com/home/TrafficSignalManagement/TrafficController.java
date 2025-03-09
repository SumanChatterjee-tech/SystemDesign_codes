package com.home.TrafficSignalManagement;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TrafficController {

    private final List<Road> roads;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TrafficController(List<Road> roads) {
        this.roads = roads;
    }
    
    public void startSignalCycle() {
        executor.execute(() -> {
            while (true) {
                for (Road road : roads) {
                    changeSignal(road.getTiTrafficSignal(), Signal.GREEN, 10); // Green for 10 sec
                    changeSignal(road.getTiTrafficSignal(), Signal.YELLOW, 3); // Yellow for 3 sec
                    changeSignal(road.getTiTrafficSignal(), Signal.RED, 7); // Red for 7 sec
                }
            }
        });
    }

    private void changeSignal(TrafficSignal signal, Signal state, int duration) {
        signal.setSignal(state);
        try {
            Thread.sleep(duration * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void overrideSignal(TrafficSignal signal, Signal state) {
        System.out.println("Overriding signal to " + state);
        signal.setSignal(state);
    }
}
