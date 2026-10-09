class Solution {

    int[] parent;
    int[] size;

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (emailToAccount.containsKey(email)) {
                    union(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> groups = new HashMap<>();

        for (String email : emailToAccount.keySet()) {

            int root = find(emailToAccount.get(email));

            groups.computeIfAbsent(
                root, k -> new TreeSet<>()
            ).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry
                : groups.entrySet()) {

            int root = entry.getKey();

            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(entry.getValue());

            result.add(merged);
        }

        return result;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}
