public int bisectLeft(int[] nums, int l, int r, int val) {
    if (l > r || l < 0 || r >= nums.length)
        return -1;

    int min = l;
    int max = r;
    while (min <= max) {
        int mid = min + (max - min) / 2;
        if (nums[mid] < val)
            min = mid + 1;
        else
            max = mid - 1;
    }
    return min;
}

public int bisectRight(int[] nums, int l, int r, int val) {
    if (l > r || l < 0 || r >= nums.length)
        return -1;

    int min = l;
    int max = r;
    while (min <= max) {
        int mid = min + (max - min) / 2;
        if (nums[mid] <= val)
            min = mid + 1;
        else
            max = mid - 1;
    }
    return min;
}
