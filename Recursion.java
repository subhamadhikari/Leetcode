
public class Recursion {
    public static void main(String[] args) {
        // int x = 10;
        // recurPrint(x);
        // naturalSumv1(10, 0);
        // System.out.println(naturalSumv2(10));
        // System.out.println(powerTo(2, 5));
        // System.out.println(numberOfWays(3, 3));
        // System.out.println("Palindrome:" + palindromeCheck("abbrbba", 0, 6));
        // powerSet("abc", 0, ".");
        permutationString("abc", 0, 2);
    }

    static void recurPrint(int x) {

        if (x == 0) {
            return;
        }

        System.out.println(x + " Hello");

        recurPrint(x - 1);

    }

    static void naturalSumv1(int n, int sum) {
        if (n == 0) {
            System.out.println("The sum is:" + sum);
            return;
        }
        sum = sum + n;
        naturalSumv1(n - 1, sum);
    }

    static int naturalSumv2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n < 1) {
            return -1;
        }

        System.out.println("inside -> " + n);

        return n + naturalSumv2(n - 1);
    }

    static int powerTo(int a, int b) {
        // a^b
        if (b == 0) {
            return 1;
        }

        return a * powerTo(a, b - 1);
    }

    // Important
    // number of ways in a matrix nXm
    static int numberOfWays(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }

        return numberOfWays(n - 1, m) + numberOfWays(n, m - 1);
    }

    // Josephus problem
    static int josephusProb(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (josephusProb(n - 1, k) + k) % n;
    }

    // check for palindrome string.
    // l and r are extreme indices;l=1 & r=word.length
    static boolean palindromeCheck(String word, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (word.charAt(l) != word.charAt(r)) {
            return false;
        }

        return palindromeCheck(word, l + 1, r - 1);
    }

    // print the powerset of given string.
    // cur -> current string & i -> current index
    // complexity-> O(2^n)
    static void powerSet(String s, int i, String cur) {
        if (i == s.length()) {
            System.out.println(cur + " ");
            return;
        }

        System.out.println("i->" + i);

        powerSet(s, i + 1, cur + s.charAt(i));
        powerSet(s, i + 1, cur);

    }

    // permutation of a string.
    // O(n*n!)
    static void permutationString(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permutationString(s, l + 1, r);
            s = swap(s, l, i);
        }
    }

    static String swap(String s, int l, int r) {
        StringBuilder newS = new StringBuilder(s);
        newS.setCharAt(l, s.charAt(r));
        newS.setCharAt(r, s.charAt(l));

        return newS.toString();
    }
}

/*
 * class Solution {
 * public int[] plusOne(int[] digits) {
 * int number = 0;
 * for (int n : digits) {
 * number = (number * 10) + n;
 * }
 * int sum = number + 1;
 * 
 * int size = 0;
 * 
 * for (int i = sum + 1; i > 0; i = i / 10) {
 * size = size + 1;
 * }
 * 
 * int res[] = new int[size];
 * 
 * String string_number = Integer.toString(sum);
 * 
 * System.out.println(sum);
 * 
 * for (int i = 0; i < string_number.length(); i++) {
 * res[i] = Character.getNumericValue(string_number.charAt(i));
 * }
 * 
 * return res;
 * }
 * }
 */