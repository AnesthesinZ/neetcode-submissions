class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> adjList = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                adjList.computeIfAbsent(genPattern(word, i), k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        int res = 1;

        while (!q.isEmpty()) {

            int levelSize = q.size();
           
            for (int j = 0; j < levelSize; j++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }

                for (int i = 0; i < word.length(); i++) {
                    String pattern = genPattern(word, i);

                    for (String nei : adjList.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            q.add(nei);
                        }
                    }
                }
            }
            res ++;
        }

        return 0;

    }

    private String genPattern(String word, int i) {
        return word.substring(0, i) + "*" + word.substring(i + 1);
    }
}
