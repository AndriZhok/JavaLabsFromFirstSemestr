import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для представлення числа Фібоначчі.
 */
class FibonacciNumber {
    private int index;
    private long value;

    public FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    /**
     * Перевіряє, чи є число простим.
     *
     * @return true, якщо число є простим, і false, якщо ні.
     */
    public boolean isPrime() {
        if (value < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class FibonacciPrimeChecker {

    /**
     * Генерує перші N чисел Фібоначчі.
     *
     * @param n кількість чисел Фібоначчі, які потрібно згенерувати.
     * @return список об'єктів FibonacciNumber.
     */
    public static List<FibonacciNumber> generateFibonacciNumbers(int n) {
        List<FibonacciNumber> fibonacciNumbers = new ArrayList<>();
        long a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            fibonacciNumbers.add(new FibonacciNumber(i, a));
            long temp = a;
            a = b;
            b = temp + b;
        }

        return fibonacciNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Фібоначчі (N): ");
        int n = scanner.nextInt();

        List<FibonacciNumber> fibonacciNumbers = generateFibonacciNumbers(n);

        System.out.println("Числа Фібоначчі та їх простота:");
        for (FibonacciNumber fibonacciNumber : fibonacciNumbers) {
            String primeStatus = fibonacciNumber.isPrime() ? "є простим" : "не є простим";
            System.out.println("Номер: " + fibonacciNumber.getIndex() + ", Значення: " + fibonacciNumber.getValue() + " - " + primeStatus);
        }
    }
}