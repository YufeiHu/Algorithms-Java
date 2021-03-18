public static void reverseList(List<Integer> nums) {
    for(int i = 0; i < nums.size() / 2; i++) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(nums.size() - i - 1));
        nums.set(nums.size() - i - 1, tmp);
    }
}

public boolean topologicalSortHelper(Map<Integer, List<Integer>> graph, int[] visited, List<Integer> ans, int node) {
    // 1: visited
    // 0: unvisited
    // -1: visiting
    // Return boolean value means whether it is a DAG or not
    if (visited[node] == 1) {
        return true;
    } else if (visited[node] == -1) {
        return false;
    } else {
        visited[node] = -1;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!topologicalSortHelper(graph, visited, ans, neighbor)) {
                    return false;
                }
            }
        }
        visited[node] = 1;
        ans.add(node);
        return true;
    }
}

public boolean topologicalSort(Map<Integer, List<Integer>> graph, List<Integer> ans, int n) {
    int[] visited = new int[n];
    for (int node = 0; node < n; node++) {
        if (!topologicalSortHelper(graph, visited, ans, node)) {
            return false;
        }
    }
    reverseList(ans);
    return true;
}
