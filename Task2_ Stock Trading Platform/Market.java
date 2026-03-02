import java.util.*;

public class Market {

    private HashMap<String, Stock> stocks = new HashMap<>();

    public Market() {
        stocks.put("TCS", new Stock("TCS", 3500));
        stocks.put("INFY", new Stock("INFY", 1500));
        stocks.put("RELIANCE", new Stock("RELIANCE", 2800));
    }

    public void displayMarket() {
        System.out.println("\n===== MARKET DATA =====");

        for (Stock stock : stocks.values()) {
            stock.updatePrice(); // simulate fluctuation
            System.out.println(stock.getSymbol() + " : " + stock.getPrice());
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }
}