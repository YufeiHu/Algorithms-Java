/*
 * A binary indexed tree or Fenwick tree is a data structure that stores
 * an array of values and can efficiently compute prefix sums of the values
 * and update the values. It also supports an efficient rank-search operation
 * for finding the longest prefix whose sum is no more than a specified value.
 */
class BinaryIndexedTree {
    public int[] bit;

    public BinaryIndexedTree(int length) {
        this.bit = new int[length + 1];
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += this.bit[i];
            i -= (i & -i);
        }
        return sum;
    }

    public void update(int i, int delta) {
        while (i < this.bit.length) {
            this.bit[i] += delta;
            i += (i & -i);
        }
    }
}
