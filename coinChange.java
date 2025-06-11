import java.util.Arrays;

public class coinChange {

    public int countWays(int[] coins, int n, int target, int[][] dp) {
        if (target == 0) return 1;
        if (n == 0 || target < 0) return 0;

        if (dp[n][target] != -1) return dp[n][target];

        int include = countWays(coins, n, target - coins[n - 1], dp);

        int exclude = countWays(coins, n - 1, target, dp);

        dp[n][target] = include + exclude;
        return dp[n][target];
    }

    public static void main(String[] args) {
        coinChange cc = new coinChange();
        int[] coins = {1, 2, 5};
        int target = 5;
        int[][] dp = new int[coins.length + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        System.out.println("Total combinations: " + cc.countWays(coins, coins.length, target, dp));
    }
}
