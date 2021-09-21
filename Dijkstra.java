public double dijkstra(int numNodes, Map<Integer, List<Entry>> graph, int start, int end) {
    PriorityQueue<Entry> pq = new PriorityQueue<Entry>((e1, e2) -> {
        if (e1.cost > e2.cost)
            return 1;
        else if (e1.cost < e2.cost)
            return -1;
        else
            return 0;
    });
    pq.add(new Entry(start, 0));
    
    Set<Integer> seen = new HashSet<>();
    double[] minCosts = new double[numNodes];
    Arrays.fill(minCosts, Double.POSITIVE_INFINITY);
    Integer[] previousNode = new Integer[numNodes];

    while (!pq.isEmpty()) {
        Entry entry = pq.poll();
        int v1 = entry.vertex;
        double currCost = entry.cost;
        
        if (!seen.contains(v1)) {
            seen.add(v1);
            if (v1 == end)
                return currCost;

            if (graph.containsKey(v1)) {
                for (Entry neighbor : graph.get(v1)) {
                    int v2 = neighbor.vertex;
                    double nextCost = currCost + neighbor.cost;
                    if (nextCost < minCosts[v2]) {
                        minCosts[v2] = nextCost;
                        previousNode[v2] = v1;
                        pq.add(new Entry(v2, nextCost));
                    }
                }
            }
        }
    }
    
    return Double.POSITIVE_INFINITY;
}

class Entry {
    public int vertex;
    public double cost;
    
    public Entry(int vertex, double cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return String.format("(vertex=%d, cost=%f)", this.vertex, this.cost);
    }
}
