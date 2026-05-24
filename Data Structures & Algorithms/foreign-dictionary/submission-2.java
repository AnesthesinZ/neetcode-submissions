class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();

        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                adjList.putIfAbsent(word.charAt(i), new HashSet<>());
                indegrees.put(word.charAt(i), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length() &&
                word1.substring(0, minLen).equals(word2.substring(0, minLen))
            ) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (word1.charAt(j) == word2.charAt(j)) {
                    continue;
                }

                char smallChar = word1.charAt(j);
                char largeChar = word2.charAt(j);

                if (!adjList.get(smallChar).contains(largeChar)) {
                    adjList.get(smallChar).add(largeChar);
                    indegrees.put(largeChar, indegrees.getOrDefault(largeChar, 0) + 1);
                }
                break;
            }
        }

        Queue<Character> q = new LinkedList<>();

        indegrees.forEach((k, v)-> {
            if (v == 0) {
                q.add(k);
            }
        });

        StringBuilder path = new StringBuilder();

        while (!q.isEmpty()) {
            char ch = q.poll();
            path.append(ch);

            for (char nei : adjList.getOrDefault(ch, Collections.emptySet())) {
                indegrees.put(nei, indegrees.get(nei)-1);
                if (indegrees.get(nei) == 0) {
                    q.add(nei);
                }
            }
        }

        if (path.length() == indegrees.size()) {
            return path.toString();
        }

        return "";
    }
}
