import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число n (> 1): ");
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 1) {
            System.out.println("Число должно быть больше 1.");
            return;
        }

        findAndPrintPrimeFactors(n,2);
    }
    public static boolean isPrime(int n, int divisor) {
        if (n <= 2) {
            return (n == 2);
        }
        if (n % divisor == 0) {
            return false;
        }
        if (divisor * divisor > n) {
            return true;
        }
        return isPrime(n, divisor + 1);
    }

    public static void findAndPrintPrimeFactors(int n,int divisor) {
        if (n <= 2) {
            System.out.println(n);
        }
        if (n % divisor == 0 && isPrime(divisor,2)) {
            System.out.println(divisor+" ");
        }
        if(divisor <= n) {
            findAndPrintPrimeFactors(n, divisor + 1);
        }

    }
}
