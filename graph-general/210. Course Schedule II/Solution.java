class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[numCourses]; //Kahn's algorithm

        for (int[] prerequisite: prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            if (!adj.containsKey(b))
                adj.put(b, new ArrayList<>());

            adj.get(b).add(a);
            indegree[a]++;
        }

        return topologicalSort(adj, numCourses, indegree);
    }

    public int[] topologicalSort(HashMap<Integer, List<Integer>> adj, int numCourses, int[] indegree) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[count++] = u;

            for (int v: adj.getOrDefault(u, Collections.emptyList())) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (count == numCourses) return result;

        return new int[0];
    }
}