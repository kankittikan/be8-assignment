import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeBuilderTest {
    private static final TreeBuilder treeBuilder = new TreeBuilder();

    @Test
    public void inputLowerThan4() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            treeBuilder.build(3);
        });
        assertEquals("input must more than 4", throwable.getMessage());
    }

    @Test
    public void inputNotLowerThan4() {
        assertDoesNotThrow(() -> {
            treeBuilder.build(4);
        });
    }

    @Test
    public void inputHigherThan1000() {
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> {
            treeBuilder.build(1001);
        });
        assertEquals("input exceed the limit", throwable.getMessage());
    }

    @Test
    public void inputNotHigherThan1000() {
        assertDoesNotThrow(() -> {
            treeBuilder.build(1000);
        });
    }

    @Test
    public void treeWithN4() {
        String tree = """
                    *
                  * * *
                * * * * *
                    *
                  * * *""";
        assertEquals(tree, treeBuilder.build(4));
    }

    @Test
    public void treeWithN5() {
        String tree = """
                      *
                    * * *
                  * * * * *
                * * * * * * *
                      *
                    * * *""";
        assertEquals(tree, treeBuilder.build(5));
    }

    @Test
    public void treeWithN6() {
        String tree = """
                        *
                      * * *
                    * * * * *
                  * * * * * * *
                * * * * * * * * *
                        *
                      * * *""";
        assertEquals(tree, treeBuilder.build(6));
    }

}