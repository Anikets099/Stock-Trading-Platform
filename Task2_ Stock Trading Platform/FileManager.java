import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    public static void savePortfolio(HashMap<String, Integer> portfolio) {

        try {
            FileWriter writer = new FileWriter("portfolio.txt");

            for (String symbol : portfolio.keySet()) {
                writer.write(symbol + " : " + portfolio.get(symbol) + "\n");
            }

            writer.close();
            System.out.println("Portfolio saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}