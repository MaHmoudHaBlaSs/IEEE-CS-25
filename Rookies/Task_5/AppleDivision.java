import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalWeights = scanner.nextInt();
        long[] weights = new long[totalWeights];

        for (int i = 0; i < totalWeights; i++) {
            weights[i] = scanner.nextLong();
        }

        System.out.println(minimizeDifference(weights, totalWeights, 0, 0));
    }

    public static long minimizeDifference(long[] weights, int remainingWeights, long sumGroup1, long sumGroup2) {
        if (remainingWeights == 0) {
            return Math.abs(sumGroup1 - sumGroup2);
        }

        long addToGroup1 = minimizeDifference(weights, remainingWeights - 1, sumGroup1 + weights[remainingWeights - 1], sumGroup2);
        long addToGroup2 = minimizeDifference(weights, remainingWeights - 1, sumGroup1, sumGroup2 + weights[remainingWeights - 1]);

        return Math.min(addToGroup1, addToGroup2);
    }
}
