package com.home.Crickbuzz;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {

    Deque<PlayerDetails> bowlersList;
    Map<PlayerDetails, Integer> bowlerVsOverCount;
    PlayerDetails currentBowler;
    
    public PlayerBowlingController(List<PlayerDetails> bowlers) {
    	setBowlerList(bowlers);
    }
    
    public void setBowlerList(List<PlayerDetails> bowlers) {
    	this.bowlersList = new LinkedList<>();
    	this.bowlerVsOverCount = new HashMap<>();
    	for(PlayerDetails player : bowlers) {
    		bowlersList.add(player);
    		bowlerVsOverCount.put(player, 0);
    	}
    }
    
    public void getNextBowler(int maxOverCountPerBowler) {

        PlayerDetails playerDetails = bowlersList.poll();
        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        }
        else {
            currentBowler = playerDetails;
            bowlersList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }
    }

    public PlayerDetails getCurrentBowler(){
        return currentBowler;
    }
}
