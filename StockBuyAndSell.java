public class StockBuyAndSell {
    public static void main(String[] args) {
        int stocks[] = { 3, 1, 4, 8, 7, 2, 5 };
        int buysell[] = { 5, 2, 6, 1, 4, 7, 3, 6 };
        // maximizeProfit(stocks);
        maxProfitV1(buysell);
    }

    static void maximizeProfit(int[] prices) {
        int size = prices.length;
        int minPrice = prices[0];
        int minDay = 0;
        int maxPrice = 0;
        int maxDay = -1;

        for (int i = 1; i < size; i++) {
            if (minPrice > prices[i]) {
                maxPrice = minPrice;
                maxDay = i - 1;
                minPrice = prices[i];
                minDay = i;
            }
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
                maxDay = i;
            }
        }

        // alternative
        /*
         * int minSoFar = prices[0];
         * int maxProfit = 0;
         * for (int i = 0; i < prices.length; i++) {
         * minSoFar = Math.min(minSoFar, prices[i]);
         * int profit = prices[i] - minSoFar;
         * maxProfit = Math.min(maxProfit, profit);
         * }
         * System.out.println("Max:"+maxProfit);
         */

        System.out.println("Maximum price :" + maxPrice + " at day " + (maxDay + 1));
        System.out.println("Minimum price :" + minPrice + " at day " + (minDay + 1));
        System.out.println("Total profit:" + (maxPrice - minPrice));
    }

    // if you buy a stock then you have to sell before buying again
    // and find out the maximum profit.
    static void maxProfitV1(int prices[]) {
        int size = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < size; i++) {
            if (minPrice < prices[i]) {
                maxProfit = maxProfit + (prices[i] - minPrice);
                minPrice = prices[i];
            } else {
                minPrice = prices[i];
            }
        }

        // alternative
        // int profit = 0;
        // for (int i = 1; i < size; i++) {
        // if (prices[i] > prices[i-1]) {
        // profit += (prices[i]-prices[i-1]);
        // }
        // }

        System.out.println("Max:" + maxProfit);
    }
}
