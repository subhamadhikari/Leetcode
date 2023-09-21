public class Rainwater {
    // Rainwater Trapping Problem
    public static void main(String[] args) {
        int b_height[] = { 3, 1, 2, 4, 0, 1, 3, 2 };
        rainWater(b_height);
    }

    static void rainWater(int a[]) {
        int n = a.length;
        int left[] = new int[n];
        int right[] = new int[n];

        // left
        left[0] = a[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], a[i]);
        }

        // right
        right[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((Math.min(left[i], right[i])) - a[i]);
        }

        System.out.println("Number of water blocks:" + ans);
    }
}
