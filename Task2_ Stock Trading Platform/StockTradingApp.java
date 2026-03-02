import java.util.Scanner;

public class StockTradingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        User user = new User("Aniket", 100000);

        while (true) {

            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Save Portfolio");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    market.displayMarket();
                    break;

                case 2:
                    System.out.print("Enter symbol: ");
                    String buySymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    user.buyStock(market.getStock(buySymbol), buyQty);
                    break;

                case 3:
                    System.out.print("Enter symbol: ");
                    String sellSymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    user.sellStock(market.getStock(sellSymbol), sellQty);
                    break;

                case 4:
                    user.showPortfolio(market);
                    break;

                case 5:
                    user.showTransactions();
                    break;

                case 6:
                    FileManager.savePortfolio(user.getPortfolio());
                    break;

                case 7:
                    System.out.println("Thank you for trading!");
                    return;
            }
        }
    }
}