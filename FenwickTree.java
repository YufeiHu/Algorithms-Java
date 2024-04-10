class FenwickTree {
    private int[] tree;

    public FenwickTree(int n) {
        this.tree = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < this.tree.length) {
            this.tree[i] += delta;
            i += i & -i; // move to the next node
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += this.tree[i];
            i -= i & -i; // move to the parent node
        }
        return sum;
    }
}
