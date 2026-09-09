class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, List<Map<String, Double>>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(Map.of(v, val));

            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(Map.of(u, 1.0/val));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            double ans = -1.0;
            double product = 1.0;

            if (adj.containsKey(src)) {
                Set<String> visited = new HashSet<>();
                ans = dfs(src, dest, adj, visited, product);
            }

            result[i] = ans;
        }
        return result;
    }

    public double dfs(String src, String dest, Map<String, List<Map<String, Double>>> adj, Set<String> visited, double product) {
        if (visited.contains(src)) return -1.0;

        visited.add(src);

        if (src.equals(dest)) return product;

        for (Map<String, Double> p: adj.get(src)) {
            for (Map.Entry<String, Double> entry: p.entrySet()) {
                String v = entry.getKey();
                Double val = entry.getValue();

                double pathResult = dfs(v, dest, adj, visited, val * product);

                if (pathResult != -1.0)
                    return pathResult;
            }
        }
        return -1.0;
    }
}