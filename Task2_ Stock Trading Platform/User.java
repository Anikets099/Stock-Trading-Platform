import java.util.*;

public class User {

    private String name;
    private double balance;
    private HashMap<String, Integer> portfolio = new HashMap<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private double totalInvestment = 0;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void buyStock(Stock stock, int qty) {
        double cost = stock.getPrice() * qty;

        if (cost > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= cost;
        totalInvestment += cost;

        portfolio.put(stock.getSymbol(),
                portfolio.getOrDefault(stock.getSymbol(), 0) + qty);

        transactions.add(new Transaction("BUY", stock.getSymbol(), qty, stock.getPrice()));

        System.out.println("Stock bought successfully!");
    }

    public void sellStock(Stock stock, int qty) {

        int owned = portfolio.getOrDefault(stock.getSymbol(), 0);

        if (owned < qty) {
            System.out.println("Not enough shares!");
            return;
        }

        double revenue = stock.getPrice() * qty;
        balance += revenue;

        portfolio.put(stock.getSymbol(), owned - qty);

        transactions.add(new Transaction("SELL", stock.getSymbol(), qty, stock.getPrice()));

        System.out.println("Stock sold successfully!");
    }

    public void showPortfolio(Market market) {

        double currentValue = 0;

        System.out.println("\n===== PORTFOLIO =====");

        for (String symbol : portfolio.keySet()) {
            int qty = portfolio.get(symbol);
            double price = market.getStock(symbol).getPrice();
            double value = qty * price;

            currentValue += value;

            System.out.println(symbol + " | Qty: " + qty + " | Current Value: " + value);
        }

        double profitLoss = currentValue - totalInvestment;

        System.out.println("Balance: " + balance);
        System.out.println("Total Investment: " + totalInvestment);
        System.out.println("Current Value: " + currentValue);
        System.out.println("Profit/Loss: " + profitLoss);
    }

    public void showTransactions() {
        System.out.println("\n===== TRANSACTIONS =====");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }
}