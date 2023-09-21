import java.util.Stack;

/**
 * LargestRecHistogram
 */
public class LargestRecHistogram {

    public static void main(String[] args) {
        int maxAns = 0;
        int[] arr = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
        int[] pS = PrevSmaller(arr);
        int[] nS = NextSmaller(arr);

        for (int i = 0; i < args.length; i++) {
            int cur = (nS[i] - pS[i] - 1) * arr[i];
            maxAns = Math.max(maxAns, cur);
        }

        System.out.println("maxArea" + maxAns);
    }

    public static int[] PrevSmaller(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        int[] prevSmaller = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }

            // pushing the index.
            stack.push(i);
        }
        return prevSmaller;
    }

    public static int[] NextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmaller[i] = -1;
            } else {
                nextSmaller[i] = stack.peek();
            }

            stack.push(i);
        }

        return nextSmaller;
    }
}