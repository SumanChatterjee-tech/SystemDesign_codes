package com.home.SplitwiseEasyToUnderstand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final LocalDateTime timestamp;

    public Expense(String description, double amount, User paidBy, List<Split> splits) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.timestamp = LocalDateTime.now();
    }


}
