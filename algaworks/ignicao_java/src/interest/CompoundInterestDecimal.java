import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundInterestDecimal {

    private final static BigDecimal CEM = BigDecimal.valueOf(100);
    private final static int SCALE_PROCESS = 10;
    private final static int SCALE_SHOW = 2;

    public static void processByMonthBigDecimal(BigDecimal inicialAmount, BigDecimal interestRate, int durationInMonths) {

        BigDecimal accumulatedAmount = inicialAmount;

        int month = 0;
        int year = 0;
        for (int countMonth = 1; countMonth <= durationInMonths; countMonth++) {
            month ++;
            if(year == 0 || month > 12) {
                month = 1;
                year ++;
                System.out.printf("%n====> ANO: %d%n", year);
            }

            accumulatedAmount = accumulatedAmount.multiply(
                BigDecimal.ONE.add(
                    interestRate.divide(
                            CEM,
                            SCALE_PROCESS,
                            RoundingMode.HALF_UP
                    )
                )
            );

            System.out.printf("Mês %02d: R$ %s%n", month, accumulatedAmount.setScale(SCALE_SHOW, RoundingMode.HALF_UP));

        }

    }

    public static void processTargetBigDecimal(BigDecimal inicialAmount, BigDecimal interestRate, BigDecimal targetAmount) {

        int month = 0;
        int year = 0;
        BigDecimal accumulatedAmount = inicialAmount;

        while (accumulatedAmount.compareTo(targetAmount) < 1) {

            month ++;
            if(year == 0 || month > 12) {
                month = 1;
                year ++;
                System.out.printf("%n%n====> ANO: %d%n", year);
            }

            accumulatedAmount = accumulatedAmount.multiply(
                BigDecimal.ONE.add(
                    interestRate.divide(
                        CEM,
                        SCALE_PROCESS,
                        RoundingMode.HALF_UP
                    )
                )
            );

            BigDecimal showAmount = accumulatedAmount.setScale(
                SCALE_SHOW,
                RoundingMode.HALF_UP
            );

            System.out.printf("Mes: %d = %.2f%n", month, showAmount);
        }

    }

}
