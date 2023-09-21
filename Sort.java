import java.util.Arrays;

/**
 * Sort
 */
public class Sort {
    public static void main(String[] args) {
        int arr[] = { 3, 7, 1, 9, 2, 6, 0, 8, 4, 5 };
        // bubbleSortV2(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        int QARR[] = { 6, 3, 9, 5, 2, 8 };
        // quickSort(QARR, 0, (QARR.length - 1));

        for (int i : QARR) {
            System.out.print(i + " ");
        }
        System.out.println("");

        int arrV2[] = { 4, 6, 2, 5, 7, 9, 1, 3 };
        quickSortV2(arrV2, 0, arrV2.length - 1);
        for (int i : arrV2) {
            System.out.print(i + " ");
        }
        System.out.println("");

    }

    static void bubbleSort(int nums[]) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if ((nums[j + 1] < nums[j])) {
                    int num = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = num;
                }
            }
        }

        System.out.println("Sorted numbers");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    static void bubbleSortV2(int nums[]) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < size - i - 1; j++) {
                if ((nums[j + 1] < nums[j])) {
                    swap = true;
                    int num = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = num;
                }
            }
            if (!swap) {
                break;
            }
        }

        System.out.println("Sorted numbers");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    static void selectionSort(int nums[]) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }

        System.out.println("2. selection Sorted numbers");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    static void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        System.out.println("Insertion Sort");
        for (int i : arr) {

            System.out.print(i + " ");
        }
    }

    // ----------------------------v1-------------------
    static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotInd = partition(nums, low, high);
            quickSort(nums, low, pivotInd - 1);
            quickSort(nums, pivotInd + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i; // pivot index
    }
    // ---------------------------v2Q.Sort---------------------------------

    static void quickSortV2(int[] nums, int low, int high) {
        if (low < high) {
            int pivotInd = partitionv2(nums, low, high);
            quickSort(nums, low, pivotInd - 1);
            quickSort(nums, pivotInd + 1, high);
        }

    }

    static int partitionv2(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l;
        int j = h;

        while (i < j) {
            while (arr[i] <= pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            // swap after breaking loop
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap with low

        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;

        return j; // pivot element's index in sorted array
    }

    // -------------------------------------------------------
    static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // left
            mergeSort(nums, l, mid);
            // right
            mergeSort(nums, mid + 1, r);
            // merge
        }
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int[] b = arr;
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                b[k] = arr[i];
                i++;
            } else {
                b[k] = arr[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j <= r) {
                b[k] = arr[j];
                k++;
                j++;
            }
        } else {
            while (i <= mid) {
                b[k] = arr[i];
                k++;
                i++;
            }
        }

        for (int k2 = 0; k2 < b.length; k2++) {
            arr[k2] = b[k2];
        }
    }

    // -----------------------------------------------------------------------------------------------------
    // Book Allocation problem
    // Minimize th maximum numbers of pages read by a student
    static void bookAllocation(int[] books) {

    }

    static int minPages(int[] books, int students) {
        int min = maxOf(books);
        int max = sumOf(books);
        int res = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isFeasible(books, students, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    static int maxOf(int[] books) {
        int max = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i] > max) {
                max = books[i];
            }
        }
        return max;
    }

    static int sumOf(int[] books) {
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum = sum + books[i];
        }
        return sum;
    }

    static boolean isFeasible(int books[], int students, int res) {
        int student = 1, sum = 0;
        for (int i = 0; i < books.length; i++) {
            if (sum + books[i] > res) {
                student++;
                sum = books[i];
            } else {
                sum += books[i];
            }
        }
        return student <= students;
    }

}