public int knapsack(int[] weights, int[] values, int capacity) {
    int[][] memo = new int[weights.length + 1][capacity + 1];

    for (int i = 0; i < weights.length; i++) {
        for (int cap = 1; cap <= capacity; cap++) {
            if (weights[i] > cap)
                memo[i + 1][cap] = memo[i][cap];
            else
                memo[i + 1][cap] = Math.max(memo[i][cap], values[i] + memo[i][cap - weights[i]]);
        }
    }

    return memo[weights.length][capacity];
}
