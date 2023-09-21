public class MaximunSumSubArray {
    public static void main(String[] args) {
        int nums[] = { -2, -3, -4, 3, -2, -1, -5, -3 };
        // System.out.println(maxSumSubArr(nums))
        System.out.println(kadanesAlgo(nums));
        ;
    }

    // Bruteforce
    // O(n^2)
    static int maxSumSubArr(int[] nums) {
        int maxSum = -1;
        int subIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum = (sum > maxSum) ? sum : maxSum;
                subIndex = (sum == maxSum) ? i : subIndex;
            }

        }
        System.out.println("index:" + subIndex);
        return maxSum;
    }

    // Kadane's Algorithm
    // O(n)
    static int kadanesAlgo(int[] arr) {
        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum <= 0) {
                sum = 0;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
        }

        if (maxSum == 0) {
            negSum(arr);
        }
        return maxSum;
    }

    // for negative
    static void negSum(int[] arr) {
        int max = arr[0];
        for (int index = 0; index < arr.length; index++) {
            if (max < arr[index]) {
                max = arr[index];
            }
        }

        System.out.println("Max Sum possible for all the negative element array " + max);
    }
}
