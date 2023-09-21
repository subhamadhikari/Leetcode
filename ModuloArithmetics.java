/**
 * modulo-arithmetics
 */
public class ModuloArithmetics {
    public static void main(String[] args) {
        // System.out.println(fastPower(3, 5));
        // System.out.println(fastPower2(3, 3, 1000000007));
        int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(arr));
    }

    static int fastPower(int a, int b) {
        int res = 1;

        while (b > 0) {
            if (b % 2 != 0) {
                res = res * a;
            }

            a = a * a;
            b = b / 2;
        }

        return res; // a^b
    }

    static long fastPower2(long a, long b, int n) {
        long res = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                res = (res % n * a % n) % n;
            }

            a = (a % n * a % n) % n;
            b = b / 2;
        }

        return res;
    }

    static int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int holder = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (holder != nums[j]) {
                    nums[i + 1] = nums[j];
                    break;
                }
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
        return 2;
    }
}