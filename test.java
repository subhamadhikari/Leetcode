import java.util.ArrayList;
import java.util.PriorityQueue;

class test {

    public static void main(String[] args) {
        int[] gas = { 5, 1, 2, 3, 4 };
        int[] cost = { 4, 4, 1, 5, 1 };

        ArrayList<Integer> startIndexes = new ArrayList<Integer>();
        int noOfStations = gas.length;

        for (int i = 0; i < noOfStations; i++) {
            if (gas[i] >= cost[i]) {
                startIndexes.add(i);
                System.out.println("stIDX : " + i);
            }
        }

        int circularIndex = -2;
        int remain = 0;

        for (int i = 0; i < startIndexes.size(); i++) {
            circularIndex = startIndexes.get(i);
            int loop = circularIndex;
            while (true) {
                if ((gas[circularIndex] + remain) >= cost[circularIndex]) {
                    remain += gas[circularIndex] - cost[circularIndex];
                } else {
                    remain = 0;
                    break;
                }
                circularIndex++;
                if (circularIndex >= noOfStations) {
                    circularIndex = 0;
                }
                if (loop == circularIndex) {
                    System.out.println(circularIndex);
                    return;
                }
            }
        }

        System.out.println("-1");

    }
}