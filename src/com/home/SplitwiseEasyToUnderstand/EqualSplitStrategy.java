package com.home.SplitwiseEasyToUnderstand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements  SplitStrategy{

    @Override
    public List<Split> calculateSplit(User paidBy, double totalAmount, List<User> participents) {
        double equalDivistion = totalAmount/participents.size();
        List<Split> result = new ArrayList<>();
        for(User u: participents){
            result.add(new Split(u, equalDivistion));
        }
        return result;
    }
}
