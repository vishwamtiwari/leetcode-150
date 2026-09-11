class Solution {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//
//        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
//
//        for (int[] prerequisite: prerequisites) {
//            int dependsOn = prerequisite[1];
//            int dependent = prerequisite[0];
//
//            adjList.computeIfAbsent(dependsOn, k -> new ArrayList<>()).add(dependent);
//        }
//
//        int[] state = new int[numCourses];
//        for (int course = 0; course < numCourses; course++) {
//            if (!dfs(course, adjList, state)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean dfs(int course, Map<Integer, List<Integer>> adjList, int[] state) {
//        if (state[course] == 1) return false;
//        if (state[course] == 2) return true;
//
//        state[course] = 1;
//        for (int i: adjList.getOrDefault(course, Collections.emptyList())) {
//            if (!dfs(i, adjList, state))
//                return false;
//        }
//        state[course] = 2;
//        return true;
//    }

    /*
        Kahn's algorithm
        topological sort through BFS - cycle detection
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegrees = new int[numCourses];

        // creating adj list and indegress
        for (int[] prerequisite: prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            if (!adj.containsKey(u))
                adj.put(u, new ArrayList<>());

            adj.get(u).add(v);
            indegrees[v]++;
        }

        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        // adding elements with no prior dependencies to BFS queue
        for (int u = 0; u < numCourses; u++) {
            if (indegrees[u] == 0) {
                queue.offer(u);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v: adj.getOrDefault(u, Collections.emptyList())) {
                indegrees[v]--;

                if (indegrees[v] == 0) {
                    queue.offer(v);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}