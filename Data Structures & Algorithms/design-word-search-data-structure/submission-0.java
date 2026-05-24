class WordDictionary {

        class TrieNode {
            Map<Character, TrieNode> children;
            boolean word;

            public TrieNode() {
                children = new HashMap<>();
                word = false;
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur = cur.children.computeIfAbsent(word.charAt(i), t-> new TrieNode());
            }
            cur.word = true;
        }

         public boolean search(String word) {
            Queue<TrieNode> searchQueue = new LinkedList<>();
            searchQueue.add(root);
            int i = 0;
            while (!searchQueue.isEmpty() && i < word.length()) {
                int levelSize = searchQueue.size();

                for (int j = 0; j < levelSize; j++) {
                    TrieNode cur = searchQueue.poll();
                    char ch = word.charAt(i);

                    if (cur.children.containsKey(word.charAt(i))) {
                        searchQueue.add(cur.children.get(word.charAt(i)));
                    } else if (ch == '.') {
                        searchQueue.addAll(cur.children.values());
                    }
                }
                i++;
            }
            
            while (!searchQueue.isEmpty()) {
                TrieNode cur = searchQueue.poll();
                if (cur.word) {
                    return true;
                }
            }
            
            return false;
        }
    }