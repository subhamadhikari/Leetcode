public class Heaps {
    private static final int FRONT = 1;

    public static void main(String[] args) {
        int[] array = { 20, 10, 30, 5, 50, 40 };
        int[] array2 = { -1, 10, 30, 50, 20, 35, 15 };
        // for (int i : array) {
        // System.out.print(i + " ");
        // }
        System.out.println();
        // heapifyTry(array2);
        buildHeap(array2, array2.length - 1);
        System.out.println("heapified:");
        for (int i : array2) {
            System.out.print(i + " ");
        }
    }

    // Flawed
    static void heapifyTry(int[] arr) {
        // System.out.println("in");
        int size = arr.length;
        int index = arr.length;

        while (index > 0) {
            int nodeIndex = index - 1;

            int leftChild = (2 * index) - 1;
            int rightChild = (2 * index) + 1 - 1;

            int childToSwap;
            if ((leftChild > 0 && leftChild < size) && (rightChild > 0 && rightChild < size)) {
                childToSwap = (arr[leftChild] > arr[rightChild]) ? leftChild : rightChild;
                // System.out.println("child swap " + arr[childToSwap]);
            } else if ((leftChild > 0 && leftChild < size)) {
                childToSwap = leftChild;
            } else {
                childToSwap = nodeIndex;
            }

            // System.out.println("loop");
            if (arr[childToSwap] > arr[nodeIndex]) {
                swap(arr, childToSwap, nodeIndex);
                // System.out.println("swap");
            }
            printArr(arr);
            index--;
        }

        // System.out.println("out");
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    // this is also flawed
    static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = (2 * i);
        int r = (2 * i) + 1;

        if (l <= n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r <= n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, l);
        }

    }
}
