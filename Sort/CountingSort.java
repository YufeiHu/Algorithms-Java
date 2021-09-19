/*
 * Original array nums is not modified.
 *
 * Counting sort algorithm's complexity is:
 *     time = O(n + k)
 *     space = O(n + k)
 *     where k = max(nums)
 * Apply this algorithm when O(k) <= O(n), and when all numbers in nums are >= 0.
 */
public int[] countingSort(int[] nums) {
    // step 1: handle corner case
    if (nums.length <= 1)
        return nums;

    // step 2: get freqs
    int max = Arrays.stream(nums).max().getAsInt();
    int[] freqs = new int[max + 1];
    for (int num : nums)
        freqs[num]++;

    // step 3: get accumulativeFreqs
    int[] accumulativeFreqs = new int[max + 1];
    for (int num = 0; num <= max; num++) {
        if (num == 0)
            accumulativeFreqs[num] = freqs[num];
        else
            accumulativeFreqs[num] = freqs[num] + accumulativeFreqs[num - 1];
    }

    // step 4: get the sorted array
    int[] ans = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
        int num = nums[i];
        ans[accumulativeFreqs[num] - 1] = num;
        accumulativeFreqs[num]--;
    }

    return ans;
}
