public class Transaction {

    private String type;
    private String symbol;
    private int quantity;
    private double price;

    public Transaction(String type, String symbol, int quantity, double price) {
        this.type = type;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return type + " | " + symbol + " | Qty: " + quantity + " | Price: " + price;
    }
}