/*
 * Time complexity: 𝑂((𝑚+𝑛)log(𝑛))
 * m: number of operations
 * n: number of elements
 */
class UnionFind {
    public int[] parents;
    public int[] sizeComponent;
    public int numElements;
    public int numComponents;
    
    public UnionFind(int numElements) {
        this.parents = IntStream.range(0, numElements).toArray();
        this.sizeComponent = new int[numElements];
        Arrays.fill(this.sizeComponent, 1);
        this.numElements = numElements;
        this.numComponents = numElements;
    }
    
    public int find(int idx) {
        // find its root first
        int root = idx;
        while (root != this.parents[root]) {
            root = this.parents[root];
        }
        
        // path compression
        while (idx != root) {
            int idxNext = this.parents[idx];
            this.parents[idx] = root;
            idx = idxNext;
        }
        
        // return the root
        return root;
    }
    
    // return value: true means a union operation happens, false if not
    public boolean union(int i1, int i2) {
        int root1 = find(i1);
        int root2 = find(i2);
        if (root1 == root2)
            return false;
        
        if (this.sizeComponent[root1] < this.sizeComponent[root2]) {
            this.sizeComponent[root2] += this.sizeComponent[root1];
            this.parents[root1] = root2;
        } else {
            this.sizeComponent[root1] += this.sizeComponent[root2];
            this.parents[root2] = root1;
        }
        
        this.numComponents--;
        return true;
    }
}
