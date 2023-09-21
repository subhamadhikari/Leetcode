import java.util.Arrays;
import java.util.Stack;

/**
 * PrevSmaller
 */
public class PrevSmaller {

    public static void main(String[] args) {
        int arr[] = { 4, 10, 5, 8, 20, 15, 3, 12 };
        int nxtSmal[] = { 3, 10, 5, 1, 15, 10, 7, 6 };
        // prevSmall(arr);
        // prevSmaller(arr);
        nextSmaller(nxtSmal);
    }

    // Optimized using space -- O(N) ? I am confused how it is optimized ?
    public static void prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(stack.peek() + " ");
            }
            stack.push(arr[i]);

        }
    }

    // Brute force -- O(N^2)
    public static void prevSmall(int[] arr) {
        int size = arr.length;
        int[] small = new int[size];
        Arrays.fill(small, -1);

        for (int i = 0; i < small.length; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.println("i" + arr[i]);
                System.out.println("j" + arr[j]);
                System.out.println("-----");
                if (arr[j] < arr[i]) {
                    small[i] = arr[j];
                    break;
                }
            }

        }

        for (int i : small) {
            System.out.print(i + " ");
        }

    }

    // Next smaller
    public static void nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] val = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                val[i] = -1;
            } else {
                val[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        for (int i : val) {
            System.out.print(i + " ");
        }
    }
}