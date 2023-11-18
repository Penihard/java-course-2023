package edu.hw3.Stock;

public interface IStockMarket {

    void add(Stock stock);

    void remove(Stock stock);

    Stock mostValuableStock();
}
