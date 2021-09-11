public int[] bubbleSort(int[] nums) {
    int numSortSteps = 0;
    int[] ans = nums.clone();

    for (int r = ans.length - 2; r >= 0; r--) {
        for (int l = 0; l <= r; l++) {
            if (ans[l] > ans[l + 1]) {
                int tmp = ans[l];
                ans[l] = ans[l + 1];
                ans[l + 1] = tmp;
                numSortSteps++;
            }
        }
    }

    return ans;
}
