import java.util.Arrays;
import java.util.Scanner;

/**
 * factorial
 */
public class factorial {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();

        // trailingZeroes(num);

        palindromeNumber(11211);
        boolean[] prime = seiveOfEratoSthenes(4);
        System.out.println(gcd(60, 24));

    }

    public static void trailingZeroes(int num) {
        int res = 0;
        for (int i = 5; i <= num; i = i * 5) {
            res = res + (num / i);
        }
        System.out.println(res);
    }

    public static void palindromeNumber(int num) {
        int rev = 0;
        for (int i = num; i > 0; i = (i / 10)) {
            rev = (rev * 10) + (i % 10);
        }
        System.out.println("reversed " + rev);
        if (rev == num) {
            System.out.println("Number is palindrome!");
            return;
        }
        System.out.println("Number isn't palindrome");
    }

    static boolean[] seiveOfEratoSthenes(int num) {
        boolean[] isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            for (int j = 2 * i; j <= num; j = j + i) {
                isPrime[j] = false;
            }
        }
        for (int i = 0; i < isPrime.length; i++) {
            System.out.println(i + " " + isPrime[i]);
        }
        return isPrime;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}