import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();

        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        System.out.println(treeBuilder.build(n));
    }
}
