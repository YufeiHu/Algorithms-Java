/*
 * Original array nums is not modified.
 */
public int[] insertionSort(int[] nums) {
    int[] ans = nums.clone();

    for (int r = 1; r < nums.length; r++) {
        int key = ans[r];
        int l = r - 1;
        while (l >= 0 && ans[l] > key) {
            ans[l + 1] = ans[l];
            l--;
        }
        ans[l + 1] = key;
    }

    return ans;
}
