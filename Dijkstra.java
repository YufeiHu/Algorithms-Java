public double dijkstra(int numNodes, Map<Integer, List<Entry>> graph, int start, int end) {
    PriorityQueue<Entry> pq = new PriorityQueue<>((e1, e2) -> {
        return e1.cost - e2.cost;
    });
    pq.add(new Entry(start, 0));

    Set<Integer> seen = new HashSet<>();
    Integer[] previousNode = new Integer[numNodes];
    double[] minCosts = new double[numNodes];
    Arrays.fill(minCosts, Double.POSITIVE_INFINITY);
    minCosts[start] = 0;

    while (!pq.isEmpty()) {
        Entry entry = pq.poll();
        int v1 = entry.vertex;
        double currCost = entry.cost;

        if (seen.contains(v1)) {
            continue;
        }
        seen.add(v1);
        
        if (v1 == end) {
            return currCost;
        }

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
