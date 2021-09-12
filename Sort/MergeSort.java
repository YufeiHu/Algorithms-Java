/*
 * Original array nums is modified.
 */
public int[] mergeSort(int[] nums) {
    if (nums.length <= 1)
        return nums;

    int[] left = mergeSort(Arrays.copyOfRange(nums, 0, nums.length / 2));
    int[] right = mergeSort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));

    int l = 0;
    int r = 0;
    int i = 0;

    while (l < left.length && r < right.length) {
        if (left[l] < right[r]) {
            nums[i] = left[l];
            i++;
            l++;
        } else {
            nums[i] = right[r];
            i++;
            r++;
        }
    }

    while (l < left.length) {
        nums[i] = left[l];
        i++;
        l++;
    }

    while (r < right.length) {
        nums[i] = right[r];
        i++;
        r++;
    }

    return nums;
}
