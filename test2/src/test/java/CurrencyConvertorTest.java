import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyConvertorTest {
    private static final Map<String, Double> currencyMap = new HashMap<>();
    private static final CurrencyConvertor currencyConvertor = new CurrencyConvertor(currencyMap);

    @BeforeAll
    public static void setup() {
        currencyMap.put("WON", 33.72);
        currencyMap.put("USD", 0.028);
        currencyMap.put("YEN", 3.4);
    }

    @Test
    public void noCurrencyInMap() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            currencyConvertor.convert(5.0, "YMA");
        });
        assertEquals("currency type not found", throwable.getMessage());
    }

    @Test
    public void negativeInput() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            currencyConvertor.convert(-1.0, "WON");
        });
        assertEquals("input number must greater than 0", throwable.getMessage());
    }

    @Test
    public void zeroInput() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            currencyConvertor.convert(0.0, "WON");
        });
        assertEquals("input number must greater than 0", throwable.getMessage());
    }

    @Test
    public void inputExceedLimit() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            currencyConvertor.convert(1.1e20, "WON");
        });
        assertEquals("input number exceed the limit", throwable.getMessage());
    }

    @Test
    public void inputNotExceedLimit() {
        assertDoesNotThrow(() -> {
            currencyConvertor.convert(1e20, "WON");
        });
    }

    @Test
    public void testInput1() {
        assertEquals("33.72 WON", currencyConvertor.convert(1.0, "WON"));
        assertEquals("0.028 USD", currencyConvertor.convert(1.0, "USD"));
        assertEquals("3.4 YEN", currencyConvertor.convert(1.0, "YEN"));
    }

    @Test
    public void testWON() {
        assertEquals("3,372,000 WON", currencyConvertor.convert(100000.0, "WON"));
    }

    @Test
    public void testYEN() {
        assertEquals("3,400 YEN", currencyConvertor.convert(1000.0, "YEN"));
    }

    @Test
    public void testUSD() {
        assertEquals("140 USD", currencyConvertor.convert(5000.0, "USD"));
    }

}