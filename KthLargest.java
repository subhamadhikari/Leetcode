import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {

        anotherImplementation();
    }

    static void anotherImplementation() {
        int k = 3;
        int[] arr = { 20, 10, 60, 30, 50, 40 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println("Kth largest element " + pq.peek());

    }

    static void myImplementation() {
        int[] arr = { 20, 10, 60, 99, 30, 50, 40 };
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : arr) {
            pq.add(i);
        }

        int k = 1;

        while (k <= 3) {
            if (k == 3) {
                System.out.println(pq.peek());
                pq.poll();
            }
            pq.poll();
            k++;
        }
    }
}
