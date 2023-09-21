import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int ropes[] = { 5, 6, 8, 6, 9 };
        // myImpl(ropes);
        anotherImplementation(ropes);

    }

    // flawed
    public static void myImpl(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        int cost = 0;
        while (true) {

            int r1 = pq.peek();
            pq.poll();
            System.out.println(r1 + "..");
            int r2 = 0;
            if (!pq.isEmpty()) {
                r2 = pq.peek();
                pq.poll();
            }
            System.out.println(r2 + "r2");

            if (pq.isEmpty()) {
                cost = r1 + r2;
                break;
            }

            cost = r1 + r2;
            System.out.println(cost);
            pq.add(cost);

        }

        System.out.println("Minimum cost:" + cost);
    }

    public static void anotherImplementation(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}
