private boolean bfs(int residualGraph[][], int start, int end, int[] parents, int numVertices) {
    boolean[] seen = new boolean[numVertices];

    // step 1: create a queue, enqueue start vertex and mark start vertex as already seen
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(start);
    seen[start] = true;
    parents[start] = -1;

    // step 2: start BFS loop
    while (!queue.isEmpty()) {
        int currNode = queue.poll();

        for (int nextNode = 0; nextNode < numVertices; nextNode++) {
            if (!seen[nextNode] && residualGraph[currNode][nextNode] > 0) {
                // if we find a path to the end node, then there is no point in
                // doing BFS anymore. So we set its parent and then return true
                if (nextNode == end) {
                    parents[nextNode] = currNode;
                    return true;
                }

                queue.add(nextNode);
                parents[nextNode] = currNode;
                seen[nextNode] = true;
            }
        }
    }

    // fail to reach the end starting from start, so return false
    return false;
}

public int fordFulkerson(int graph[][], int start, int end, int numVertices) {
    int currNode;
    int nextNode;

    // step 1: create a residual graph and fill the residual graph with capacities
    //   residualGraph[y][x] indicates there is an edge from y to x with a residual capacity of residualGraph[y][x]
    //   naturally, if residualGraph[i][j] is 0, then there is no edge from y to x
    int residualGraph[][] = new int[numVertices][numVertices];
    for (currNode = 0; currNode < numVertices; currNode++) {
        for (nextNode = 0; nextNode < numVertices; nextNode++) {
            residualGraph[currNode][nextNode] = graph[currNode][nextNode];
        }
    }

    // step 2: this array is filled by BFS and will store the selected path
    int parents[] = new int[numVertices];

    // step 3: start the main loop
    int maxFlow = 0;
    while (bfs(residualGraph, start, end, parents, numVertices)) {
        // find minimum residual capacity of the edges along the path filled by BFS
        // or we can say find the maximum flow through the path found
        int pathFlow = Integer.MAX_VALUE;
        for (nextNode = end; nextNode != start; nextNode = parents[nextNode]) {
            currNode = parents[nextNode];
            pathFlow = Math.min(pathFlow, residualGraph[currNode][nextNode]);
        }

        // update residual capacities of the edges and reverse edges along the path
        for (nextNode = end; nextNode != start; nextNode = parents[nextNode]) {
            currNode = parents[nextNode];
            residualGraph[currNode][nextNode] -= pathFlow;
            residualGraph[nextNode][currNode] += pathFlow;
        }

        // add path flow to total flow
        maxFlow += pathFlow;
    }

    return maxFlow;
}
