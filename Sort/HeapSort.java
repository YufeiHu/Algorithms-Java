/*
 * Original array nums is modified.
 */
private void moveDown(int[] nums, int first, int last) {
    int largest = 2 * first + 1;
    while (largest <= last) {
        // right child exists and is larger than left child
        if (largest < last && nums[largest] < nums[largest + 1])
            largest++;

        // right child is larger than parent
        if (nums[largest] > nums[first]) {
            int tmp = nums[largest];
            nums[largest] = nums[first];
            nums[first] = tmp;

            // move down to largest child
            first = largest;
            largest = 2 * first + 1;
        } else {
            return;
        }
    }
}

public int[] heapSort(int[] nums) {
    // convert nums to heap
    int leastParent = (nums.length - 1) / 2;
    for (int i = leastParent; i >= 0; i--)
        moveDown(nums, i, nums.length - 1);

    // flatten heap into sorted array
    for (int i = nums.length - 1; i >= 1; i--) {
        if (nums[0] > nums[i]) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            moveDown(nums, 0, i - 1);
        }
    }

    return nums;
}
