package com.home.SplitwiseEasyToUnderstand;

import java.util.Map;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private BalanceSheet balanceSheet;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.balanceSheet = new BalanceSheet();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void adjustBalance(User paidby, Double amount){
        if(paidby == this) return; //invalid case
        this.balanceSheet.getBalances().merge(paidby, amount, Double::sum);
    }

    public void showBalances(){
        Map<User, Double> balances = this.balanceSheet.getBalances();

    }
}
