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
    if (nums.length <= 1)
        return nums;

    // get freqs
    int max = Arrays.stream(nums).max().getAsInt();
    int[] freqs = new int[max + 1];
    for (int num : nums)
        freqs[num]++;

    // get accumulativeFreqs
    int[] accumulativeFreqs = new int[max + 1];
    for (int i = 1; i < accumulativeFreqs.length; i++)
        accumulativeFreqs[i] = freqs[i] + accumulativeFreqs[i - 1];

    // get the sorted array
    int[] ans = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
        int num = nums[i];
        ans[accumulativeFreqs[num] - 1] = num;
        accumulativeFreqs[num]--;
    }

    return ans;
}
