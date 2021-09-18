public int knapsack(int[] weights, int[] values, int capacity) {
    int[][] memo = new int[weights.length + 1][capacity + 1];

    for (int numOfItemsTaken = 1; numOfItemsTaken <= weights.length; numOfItemsTaken++) {
        for (int cap = 1; cap <= capacity; cap++) {
            if (weights[numOfItemsTaken - 1] > cap)
                // not taking the current item
                memo[numOfItemsTaken][cap] = memo[numOfItemsTaken - 1][cap];
            else
                // max of (not taking the current item, taking the current item)
                memo[numOfItemsTaken][cap] = Math.max(memo[numOfItemsTaken - 1][cap], values[numOfItemsTaken - 1] + memo[numOfItemsTaken - 1][cap - weights[numOfItemsTaken - 1]]);
        }
    }

    return memo[weights.length][capacity];
}
