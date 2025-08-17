package com.home.StockBrokergaeSystem;

public interface ExecutionStrategy {
    boolean canExecute(Order order, double marketPrice);
}