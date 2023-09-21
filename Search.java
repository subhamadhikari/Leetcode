import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int arr[] = { 2, 0, -4, 8, 3, -7, 5, 12, 10 };
        Arrays.sort(arr);
        for (int i : arr) {
            // System.out.print(i + " ");

        }
        System.out.println("");
        // System.out.println(binarySearch(arr, 0, arr.length - 1, 10));
        // System.out.println(BS(arr));
        // BSbrutF(arr);
        // searchInfinite(arr, 1);

        int rotatedArr[] = { 20, 30, 40, 50, 60, 5, 10 };
        System.out.println(searchInRotatedArr(rotatedArr, 10));

    }

    // binary search -(recursively)
    static int binarySearch(int[] arr, int l, int h, int search) {
        // int search = 8;
        int midIndex = (l + h) / 2;

        if (l > h) {
            return -1;
        }

        if (arr[midIndex] == search) {
            return midIndex;
        } else if (arr[midIndex] < search) {
            return binarySearch(arr, midIndex + 1, h, search);
        } else {
            return binarySearch(arr, l, midIndex - 1, search);
        }

    }

    // binary search -(iteratively)
    static int BS(int arr[]) {
        int search = 12;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == search) {
                return mid;
            }
            if (arr[mid] < search) {
                low = mid + 1;
            }
            if (arr[mid] > search) {
                high = mid - 1;
            }
        }

        return -1;
    }

    // -----------------------------------------------------
    // binary search in an infinite array

    // brute force O(N)
    static void BSbrutF(int arr[]) {
        int search = -7;
        int i = 0;
        while (true) {
            try {
                if (arr[i] > search) {
                    System.out.println("No element present");
                    break;
                }

                if (search == arr[i]) {
                    System.out.println(i);
                }
            } catch (Exception e) {
                System.out.println("No element present");
                break;
            }

            i++;
        }
    }

    // O(log(N))
    static void searchInfinite(int[] arr, int search) {
        int l = 0;
        int h = 1;
        while (arr[h] < search) {
            l = h;
            h = 2 * h;
        }

        System.out.println(binarySearch(arr, l, h, search));
    }

    // ---------------------Search in sorted and rotated
    // array-----------------------------
    static int searchInRotatedArr(int[] arr, int search) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == search) {
                return mid;
            }
            if (arr[low] < arr[mid]) {
                if (search >= arr[low] && search < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (search > arr[mid] && search <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
