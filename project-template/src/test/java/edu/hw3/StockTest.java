package edu.hw3;

import edu.hw3.Stock.Stock;
import edu.hw3.Stock.StockMarket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StockTest {
    @Test
    public void stock_testStockMarketReturnsMostExpensiveStock() {

        // given
        StockMarket market = new StockMarket();
        Stock spaceapp = new Stock("Spaceapp", 666);
        Stock sibintec = new Stock("Sibintec", 10);
        Stock telegram = new Stock("Telegram", 999);
        market.add(sibintec);
        market.add(spaceapp);
        market.add(telegram);

        // when
        var answer =  market.mostValuableStock().getName();

        // then
        var expectedResult = telegram.getName();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }

    @Test
    public void stock_testStockMarketReturnsMostExpensiveStockAfterRemove() {

        // given
        StockMarket market = new StockMarket();
        Stock spaceapp = new Stock("Spaceapp", 666);
        Stock sibintec = new Stock("Sibintec", 10);
        Stock telegram = new Stock("Telegram", 999);
        market.add(sibintec);
        market.add(spaceapp);
        market.add(telegram);

        // when
        market.remove(telegram);
        var answer =  market.mostValuableStock().getName();

        // then
        var expectedResult = spaceapp.getName();
        assertThat(expectedResult)
            .isEqualTo(answer);
    }
}

