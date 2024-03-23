import java.text.DecimalFormat;
import java.util.Map;

public class CurrencyConvertor {
    private Map<String, Double> currencyMap;

    public CurrencyConvertor(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public String convert(Double thb, String type) {
        // validation
        if (thb <= 0) throw new IllegalArgumentException("input number must greater than 0");
        if (thb > 1e20) throw new IllegalArgumentException("input number exceed the limit");
        if (!currencyMap.containsKey(type)) throw new IllegalArgumentException("currency type not found");

        //convert
        Double calculated = thb * currencyMap.get(type);
        String formatted = String.format("%,f", calculated);
        formatted = formatted.contains(".") ? formatted.replaceAll("0*$","").replaceAll("\\.$","") : formatted;
        return formatted + " " + type;
    }
}
