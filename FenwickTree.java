/*
 * A Fenwick tree is also known as a BIT (binary indexed tree).
 * It can update elements and calculate prefix sums both in O(log(n)) time.
 *
 * Explanations:
 *  1. A Fenwick tree contains an array, where the i-th element contains the sum of the previous
 *     2^r elements up to i, where 2^r is the largest power of 2 that divides i.
 *  2. To get a prefix sum (e.g. sum from 0 to i), the tree is traversed from the i-th node to the
 *     root (i.e. 0-th node), adding the value of each traversed node.
 *  3. To update a value, all the nodes containing the value (from i-th node to the end) on the path
 *     to the root are updated.
 *  4. To do a range sum query, it finds the difference between two prefix sums.
 */
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
