public class TreeBuilder {
    private final String root = "  *\n* * *";

    public String build(Integer n) {
        //validation
        if (n < 4) throw new IllegalArgumentException("input must more than 4");
        if (n > 1000) throw new IllegalArgumentException("input exceed the limit");

        StringBuilder stringBuilder = new StringBuilder();

        //leave
        int whiteSpace = (n - 2) * 2;
        int star = 1;
        for (int i = 1; i < n; i++) {
            stringBuilder.append(" ".repeat(whiteSpace));
            whiteSpace -= 2;
            stringBuilder.append("* ".repeat(star).trim());
            star += 2;
            stringBuilder.append("\n");
        }

        //root
        whiteSpace = (n - 2) * 2;
        star = 1;
        for (int i = 0; i < 2; i++) {
            stringBuilder.append(" ".repeat(whiteSpace));
            whiteSpace -= 2;
            stringBuilder.append("* ".repeat(star).trim());
            star += 2;

            if (i < 1) stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}