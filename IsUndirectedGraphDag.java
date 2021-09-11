private boolean dfsIsDag(Map<Integer, List<Integer>> graph, int node, Map<Integer, Character> colorMemo, Character color) {
    if (colorMemo.containsKey(node)) {
        return colorMemo.get(node) == color;
    }
    
    // color the given node
    colorMemo.put(node, color);
    
    // if node does not have neighbor, return true
    if (!graph.containsKey(node))
        return true;
    
    // get nextColor
    Character colorNext;
    if (color == 'R')
        colorNext = 'B';
    else
        colorNext = 'R';
    
    // check for every neighbor starting from node
    for (int neighbor : graph.get(node)) {
        if (!dfsIsDag(graph, neighbor, colorMemo, colorNext))
            return false;
    }
    
    return true;
}

public boolean isDag(Map<Integer, List<Integer>> graph, int numNodes) {
    Map<Integer, Character> colorMemo = new HashMap<>();
    
    for (int node = 0; node < numNodes; node++) {
        if (!colorMemo.containsKey(node) && !dfsIsDag(graph, node, colorMemo, 'R'))
            return false;
    }
    
    return true;
}

public static void main(String[] args) {
    // graph is: 2 <-> 0 <-> 1 <-> 3
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : new int[][] {{0, 1}, {0, 2}, {1, 3}}) {
        int v1 = edge[0];
        int v2 = edge[1];
        
        if (!graph.containsKey(v1))
            graph.put(v1, new ArrayList<>());
        graph.get(v1).add(v2);
        
        if (!graph.containsKey(v2))
            graph.put(v2, new ArrayList<>());
        graph.get(v2).add(v1);
    }
    
    // expect true
    return isDag(graph, 4);
}
