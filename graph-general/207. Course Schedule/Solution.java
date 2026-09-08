class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] prerequisite: prerequisites) {
            int dependsOn = prerequisite[1];
            int dependent = prerequisite[0];

            adjList.computeIfAbsent(dependsOn, k -> new ArrayList<>()).add(dependent);
        }

        int[] state = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjList, state)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adjList, int[] state) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;
        for (int i: adjList.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(i, adjList, state))
                return false;
        }
        state[course] = 2;
        return true;
    }
}