package com.home.SplitwiseEasyToUnderstand;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {

    Map<User, Double> balances = new HashMap<>();

    public BalanceSheet() {
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }

    public void settleUp(User user, double amount){
        double txnAmount = this.balances.get(user);
        txnAmount+=amount;

        this.balances.put(user, txnAmount);
    }

    public void showBalances(User owner){
        if(this.balances.isEmpty()){
            System.out.println("All settled up!!");
            return;
        }
        int totalOwedToMe = 0;
        int totalIOwe = 0;
        for(Map.Entry<User, Double> each : balances.entrySet()){
            User otherUser = each.getKey();
            Double amount = each.getValue();
            if(amount>0.01){
                totalOwedToMe+=amount;
            }else if(amount < 0.01){
                totalIOwe += amount;
            }
        }
        System.out.println("Total Owed to " + owner.getName() + ": $" + String.format("%.2f", totalOwedToMe));
        System.out.println("Total " + owner.getName() + " Owes: $" + String.format("%.2f", totalIOwe));
    }
}
