import java.math.BigDecimal;
import java.util.Scanner;

public class InputScanner {

    public static int readIntWithDefault(Scanner scanner, String message, int defaultValue) {

        System.out.print(message);
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) return defaultValue;

        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando valor padrão: " + defaultValue);
            return defaultValue;
        }

    }

    public static BigDecimal readBigDecimalWithDefault(Scanner scanner, String message, BigDecimal defaultValue) {

        System.out.print(message);
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) return defaultValue;

        line = line.replace(",", ".");
        try {
            return new BigDecimal(line);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando valor padrão: " + defaultValue);
            return defaultValue;
        }

    }


}
