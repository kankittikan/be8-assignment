import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> currencyMap = new HashMap<>();
        currencyMap.put("WON", 33.72);
        currencyMap.put("USD", 0.028);
        currencyMap.put("YEN", 3.4);

        CurrencyConvertor currencyConvertor = new CurrencyConvertor(currencyMap);

        Scanner scanner = new Scanner(System.in);
        Double thb = scanner.nextDouble();
        String type = scanner.next();
        try {
            System.out.println(currencyConvertor.convert(thb, type));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
