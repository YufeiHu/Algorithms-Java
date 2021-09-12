/*
 * The structure of the heap looks like:
 *                   0
 *            0             1
 *                      2       3
 *                   4     5 6     7
 */
class Heap {
    private List<Integer> heap;
    
    public Heap() {
        this.heap = new ArrayList<>();
    }
    
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = i / 2;
            if (this.heap.get(parent) <= this.heap.get(i))
                return;
            
            int tmp = this.heap.get(i);
            this.heap.set(i, this.heap.get(parent));
            this.heap.set(parent, tmp);
            
            i = parent;
        }
    }
    
    private void heapifyDown(int i) {
        if (this.heap.size() == 1)
            return;
        
        while (2 * i < this.heap.size()) {
            int child = 2 * i;
            if (child + 1 < this.heap.size() && this.heap.get(child + 1) <= this.heap.get(child))
                child++;
            
            if (this.heap.get(i) <= this.heap.get(child))
                return;
            
            int tmp = this.heap.get(i);
            this.heap.set(i, this.heap.get(child));
            this.heap.set(child, tmp);
            
            i = child;
        }
    }
    
    public int poll() {
        int entryBack = this.heap.get(this.heap.size() - 1);
        this.heap.remove(this.heap.size() - 1);
        
        if (this.heap.size() == 0)
            return entryBack;
        
        int entryFront = this.heap.get(0);
        this.heap.set(0, entryBack);
        heapifyDown(0);
        
        return entryFront;
    }
    
    public int peek() {
        if (this.heap.size() == 0)
            return Integer.MIN_VALUE;
        return this.heap.get(0);
    }
    
    public void add(int num) {
        this.heap.add(num);
        heapifyUp(this.heap.size() - 1);
    }
}
