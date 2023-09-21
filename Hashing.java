import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        // hashingImplement();
        int[] arr = { 7, 7, 2, 7, 3, 7, 7, 7 };
        int[] arr2 = { 8, 7, 2, 3, 4, 0, 9 };
        int[] sum = { 10, 15, -5, 15, -10, 5 };
        int[] zerOne = { 1, 1, 1, 0, 1, 1, 0, 0 };
        // countDistictElement(arr);
        // unionOfTwoArray(arr, arr2);
        // intersectionOfArray(arr, arr2);
        // subArraySumB(sum, 5);
        // subArraySum(sum, -1);
        // largestSubArraySum01(zerOne);
        countElements(arr, 4);
        optCountElements(arr, 4);
    }

    static void hashingImplement() {
        HashSet<Integer> num = new HashSet<>();
        num.add(5);
        num.add(2);
        System.out.println(num);

        if (num.contains(2)) {
            System.out.println("Present");
        } else {
            System.out.println("Absent");
        }

        System.out.println(num.size());
        num.remove(5);
        num.clear();
        System.out.println(num);
        System.out.println(num.size());
        System.out.println(num.isEmpty());
    }

    static void countDistictElement(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        System.out.println(hs.size());
    }

    static void unionOfTwoArray(int[] a, int[] b) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : a) {
            hs.add(i);
        }
        for (int i : b) {
            hs.add(i);
        }
        System.out.println(hs.size());
    }

    static void intersectionOfArray(int[] a, int[] b) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : a) {
            hs.add(i);
        }
        int count = 0;
        for (int i : b) {
            if (hs.contains(i)) {
                count++;
                hs.remove(i);
            }
        }

        System.out.println("intersection:" + count);
    }

    // brute force
    static void subArraySumB(int[] arr, int s) {
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == s) {
                    for (int j2 = i; j2 <= j; j2++) {
                        System.out.print(arr[j2] + " ");
                    }
                    System.out.println("");
                }
            }
        }
    }

    // hashmap
    static void subArraySum(int[] arr, int s) {
        int curSum = 0;
        int start = 1;
        int end = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            if ((curSum - s) == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(curSum - s)) {
                start = map.get(curSum - s) + 1;
                end = i;
                break;
            }
            map.put((curSum), i);
        }

        if (end == -1) {
            System.out.println("No subarray found!");
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    // largest subarray with equal 0 and 1 [1,1,0,1,1,0,0]
    static void largestSubArraySum01(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            if (arr[i] == 0) {
                newArr[i] = -1;
            } else {
                newArr[i] = 1;
            }
        }

        int largest = 0;
        int currentSum = 0;
        int start = 0;
        int end = -1;

        HashMap<Integer, Integer> sum = new HashMap<>();

        for (int i = 0; i < newArr.length; i++) {
            currentSum += newArr[i];
            if (currentSum == 0) {
                int size = i - 0 + 1;
                if (size > largest) {
                    largest = size;
                    // System.out.println("size" + size);
                    start = 0;
                    end = i;
                }
            }
            if (sum.containsKey(currentSum - 0)) {
                int size = i - (sum.get(currentSum - 0) - 1) + 1;

                if (size > largest) {
                    largest = size;
                    start = sum.get(currentSum) - 1;
                    end = i;
                    // System.out.println("size" + size);
                }
            }
            sum.put(currentSum, i);
        }

        if (end == -1) {
            System.out.println("No sequence of 0 and 1 found!");
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // count distinct eements in every window of size k
    // NOT OPTIMIZED
    static void countElements(int[] nums, int k) {
        int compartments = nums.length - k + 1;
        for (int i = 0; i < compartments; i++) {
            HashMap<Integer, Integer> elements = new HashMap<>();
            for (int j = i; j < k + i; j++) {
                elements.put(nums[j], nums[j]);
            }
            System.out.println("Unique elements " + i);
            for (Map.Entry m : elements.entrySet()) {
                System.out.print(m.getKey() + " ");
            }
            System.out.println("");
        }
    }

    // OPTIMIZED
    static void optCountElements(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println("Number of unique elements:" + map.size());

        for (int i = k; i < nums.length; i++) {
            if (map.get(nums[i - k]) == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            System.out.println("Num of uniquw elements" + map.size());
        }
    }

}
