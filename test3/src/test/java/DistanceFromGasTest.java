import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceFromGasTest {
    private static DistanceFromGas distanceFromGas;

    @BeforeAll
    static void beforeAll() {
        distanceFromGas = new DistanceFromGas(95.0, 13000.0);
    }

    @Test
    void inputLowerThan1() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            distanceFromGas.calculate(0.0);
        });
        assertEquals("input value must greater than 0", throwable.getMessage());
    }

    @Test
    void inputNotLowerThan1() {
        assertDoesNotThrow(() -> {
            distanceFromGas.calculate(1.0);
        });
    }

    @Test
    void inputHigherThanLimit() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            distanceFromGas.calculate(1000000.0);
        });
        assertEquals("input value exceed the limit", throwable.getMessage());
    }

    @Test
    void inputNotHigherThanLimit() {
        assertDoesNotThrow(() -> {
            distanceFromGas.calculate(999999.0);
        });
    }

    @Test
    void input10() {
        assertEquals("123 KM", distanceFromGas.calculate(10.0));
    }

    @Test
    void input100() {
        assertEquals("1235 KM", distanceFromGas.calculate(100.0));
    }
}