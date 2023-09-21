import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * MajorityElement
 */
public class MajorityElement {

    // if the size of the Array is N, then the element IN THE ARRAY is majority
    // element if that element is present more than N/2 TIMES
    public static void main(String[] args) {
        int[] nums = { 6, 13, 13, 2, 13 };
        // System.out.println(majorityB(nums));
        // System.out.println(mjV2(nums));
        // System.out.println(mjV3(nums));
        int[] casea = { 1, 2, 3 };
        System.out.println(mooresAlgo(casea));
    }

    // bruteForce
    // time complexity - O(N^2)
    // space complexity - O(1)
    static boolean majorityB(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int hold = nums[i];
            int count = 0;
            for (int j = i; j < size; j++) {
                if (hold == nums[j]) {
                    count++;
                }
            }
            if (count > size / 2) {
                System.out.println("Majority element " + hold);
                return true;
            }

        }
        return false;
    }

    // first sort and then operate
    // time complexity - O(nlog(n))
    // spae complexity - O(1)
    static boolean mjV2(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            int maj = nums[(size / 2)];

            if (nums[i] == maj) {
                count++;
            }
            if (count > size / 2) {
                System.out.println("Majority element " + maj);
                return true;
            }
        }

        return false;
    }

    // using hashmap
    // time complexity - O(n)
    // space complexity - O(n)
    static boolean mjV3(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
            if (freq.get(nums[i]) > size / 2) {
                System.out.println("Majority->" + nums[i]);
                return true;
            }
        }
        return false;
    }

    // Moore's Voting Algorithm
    static int mooresAlgo(int[] arr) {
        int ansIndex = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[ansIndex]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ansIndex = i;
                count = 1;
            }
        }

        count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[ansIndex]) {
                count++;
            }
            if (count > (arr.length / 2)) {
                return arr[ansIndex];
            }
        }
        return -99;
    }

}