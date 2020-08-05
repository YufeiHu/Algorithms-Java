public int bubbleSort(int[] nums) {
    int numSortSteps = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
                numSortSteps++;
            }
        }
    }
    return numSortSteps;
}
