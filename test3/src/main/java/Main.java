import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DistanceFromGas distanceFromGas = new DistanceFromGas(95.0, 13000.0);

        Scanner scanner = new Scanner(System.in);
        Double liter = scanner.nextDouble();

        try {
            System.out.println(distanceFromGas.calculate(liter));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}