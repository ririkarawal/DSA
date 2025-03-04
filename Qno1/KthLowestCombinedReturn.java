package Qno1;
import java.util.PriorityQueue;

public class KthLowestCombinedReturn {

    public static int findKthLowestCombinedReturn(int[] returns1, int[] returns2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < returns1.length; i++) {
            minHeap.offer(new int[]{returns1[i] + returns2[0], i, 0});
        }

        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            count++;
            if (count == k) {
                return current[0];
            }
            if (current[2] + 1 < returns2.length) {
                minHeap.offer(new int[]{returns1[current[1]] + returns2[current[2] + 1], current[1], current[2] + 1});
            }
        }
        return -1; // This line should never be reached if k is valid
    }
    public static void main(String[] args) {
        int[] returns1 = {2, 5};
        int[] returns2 = {3, 4};
        int k = 2;
        System.out.println(findKthLowestCombinedReturn(returns1, returns2, k)); // Output: 8

        int[] returns1_2 = {-4, -2, 0, 3};
        int[] returns2_2 = {2, 4};
        int k2 = 6;
        System.out.println(findKthLowestCombinedReturn(returns1_2, returns2_2, k2)); // Output: 0
    }
}