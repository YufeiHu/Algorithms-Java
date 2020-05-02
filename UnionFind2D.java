class Tuple {
    public int l;
    public int r;
    
    public Tuple(int l, int r) {
        this.l = l;
        this.r = r;
    }
    
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + this.l;
        hash = 31 * hash + this.r;
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Tuple that = (Tuple) other;
        return (this.l == that.l) && (this.r == that.r);
    }
    
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.l, this.r);
    }
}


class UnionFind2D {
    public Map<Tuple, Tuple> parents;
    public Map<Tuple, Integer> sizeComponent;
    public int numIslands;
    public int areaMax;
    public int height;
    public int width;
    
    public UnionFind2D(int height, int width) {
        this.parents = new HashMap<>();
        this.sizeComponent = new HashMap<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tuple coord = new Tuple(y, x);
                this.parents.put(coord, new Tuple(-1, -1));
                this.sizeComponent.put(coord, 0);
            }
        }
        this.numIslands = 0;
        this.areaMax = 0;
        this.height = height;
        this.width = width;
    }
    
    public Tuple find(Tuple pos) {
        if (this.parents.get(pos).equals(new Tuple(-1, -1)))
            return new Tuple(-1, -1);
        
        Tuple root = pos;
        while (!root.equals(this.parents.get(root)))
            root = this.parents.get(root);
        
        while (!pos.equals(root)) {
            Tuple posNext = this.parents.get(pos);
            this.parents.put(pos, root);
            pos = posNext;
        }
        return root;
    }
    
    public void union(Tuple pos1, Tuple pos2) {
        Tuple empty = new Tuple(-1, -1);
        
        if (pos1.equals(pos2)) {
            Tuple root = this.parents.get(pos1);
            if (root.equals(empty)) {
                this.parents.put(pos1, pos1);
                this.sizeComponent.put(pos1, 1);
                this.numIslands++;
                this.areaMax = Math.max(this.areaMax, 1);
            }
            return;
        }
        
        Tuple root1 = find(pos1);
        if (root1.equals(empty)) {
            this.parents.put(pos1, pos1);
            this.sizeComponent.put(pos1, 1);
            root1 = pos1;
            this.numIslands++;
        }
        
        Tuple root2 = find(pos2);
        if (root2.equals(empty)) {
            this.parents.put(pos2, pos2);
            this.sizeComponent.put(pos2, 1);
            root2 = pos2;
            this.numIslands++;
        }
        
        if (root1.equals(root2))
            return;
        
        if (this.sizeComponent.get(root1) < this.sizeComponent.get(root2)) {
            this.sizeComponent.put(root2, this.sizeComponent.get(root2) + this.sizeComponent.get(root1));
            this.areaMax = Math.max(this.areaMax, this.sizeComponent.get(root2));
            this.parents.put(root1, root2);
        } else {
            this.sizeComponent.put(root1, this.sizeComponent.get(root1) + this.sizeComponent.get(root2));
            this.areaMax = Math.max(this.areaMax, this.sizeComponent.get(root1));
            this.parents.put(root2, root1);
        }
        
        this.numIslands--;
    }
}
