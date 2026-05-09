package com.home.SplitwiseEasyToUnderstand;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    public List<Split> calculateSplit(User paidBy, double totalAmount, List<User> participents);
}
