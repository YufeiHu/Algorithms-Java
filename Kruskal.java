public int kruskal(int[][] edges, int numVertices) {
    // step 1: sort all edges in non-decreasing order of their weight
    Arrays.sort(edges, (e1, e2) -> (e1[2] - e2[2]));

    // step 2: pick the smallest-weight edge each time
    UnionFind uf = new UnionFind(numVertices);
    List<int[]> edgesSelected = new ArrayList<>();
    int costAll = 0;

    for (int[] edge : edges) {
        if (edgesSelected.size() >= numVertices - 1)
            break;

        int v1 = edge[0];
        int v2 = edge[1];
        int cost = edge[2];

        int parentV1 = uf.find(v1);
        int parentV2 = uf.find(v2);

        // when no cycle is found, pick the current edge
        if (parentV1 != parentV2) {
            costAll += cost;
            edgesSelected.add(edge);
            uf.union(parentV1, parentV2);
        }
    }

    return costAll;
}

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
