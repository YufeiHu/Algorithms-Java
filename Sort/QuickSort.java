/*
 * Original array nums is modified.
 */
public int[] quickSort(int[] nums) {
    if (nums.length <= 1)
        return nums;

    // core logic
    int pivot = nums[0];
    int l = 1;
    for (int r = 1; r < nums.length; r++) {
        if (nums[r] < pivot) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
        }
    }
    l--;

    int tmp = nums[0];
    nums[0] = nums[l];
    nums[l] = tmp;

    int[] left = quickSort(Arrays.copyOfRange(nums, 0, l));
    int[] right = quickSort(Arrays.copyOfRange(nums, l + 1, nums.length));

    // concatenate left + [nums[l]] + right
    for (int i = 0; i < left.length; i++)
        nums[i] = left[i];

    nums[left.length] = nums[l];

    for (int i = 0; i < right.length; i++)
        nums[left.length + i + 1] = right[i];

    return nums;
}
