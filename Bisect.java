public int bisectLeft(int[] nums, int l, int r, int val) {
    if (l > r)
        return -1;
    if (val < nums[l])
        return l;
    if (val > nums[r])
        return r + 1;
    
    int il = l;
    int ir = r + 1;
    while (true) {
        if (il + 1 == ir) {
            if (nums[il] == val)
                return il;
            else
                return il + 1;
        }
        
        int im = (il + ir) / 2;
        if (val <= nums[im])
            ir = im;
        else
            il = im;
    }
}

public int bisectRight(int[] nums, int l, int r, int val) {
    if (l > r)
        return -1;
    if (val < nums[l])
        return l;
    if (val > nums[r])
        return r + 1;

    int il = l;
    int ir = r + 1;
    while (true) {
        if (il + 1 == ir)
            return il + 1;

        int im = (il + ir) / 2;
        if (val < nums[im])
            ir = im;
        else
            il = im;
    }
}
