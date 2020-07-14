public int dijkstra(int[][] edges, double[] costs, int start, int end) {
    // build the graph
    Map<Integer, List<Tuple>> graph = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
        int[] edge = edges[i];
        int v1 = edge[0];
        int v2 = edge[1];
        double cost = costs[i];

        if (!graph.containsKey(v1))
            graph.put(v1, new ArrayList<>());
        graph.get(v1).add(new Tuple(cost, v2));

        if (!graph.containsKey(v2))
            graph.put(v2, new ArrayList<>());
        graph.get(v2).add(new Tuple(cost, v1));
    }
    
    // run the dijkstra algorithm
    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((e1, e2) -> {
        if (e1.cost > e2.cost)
            return 1;
        else if (e1.cost < e2.cost)
            return -1;
        else
            return 0;
    });
    pq.add(new Tuple(0, start));
    Set<Integer> seen = new HashSet<>();

    while (!pq.isEmpty()) {
        Tuple entry = pq.poll();
        double costTotal = entry.cost;
        int v1 = entry.v;

        if (!seen.contains(v1)) {
            seen.add(v1);
            if (v1 == end)
                return costTotal;

            if (graph.containsKey(v1)) {
                for (Tuple entryNeighbor : graph.get(v1)) {
                    double costNext = costTotal + entryNeighbor.cost;
                    pq.add(new Tuple(costNext, entryNeighbor.v));
                }
            }
        }
    }
    
    return Double.POSITIVE_INFINITY;
}

class Tuple {
    public double cost;
    public int v;
    
    public Tuple(double cost, int v) {
        this.cost = cost;
        this.v = v;
    }
    
    @Override
    public String toString() {
        return String.format("(cost=%f, v=%d)", cost, v);
    }
}
