class PrefixTree {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean word;

        public TrieNode() {
            children = new HashMap<>();
            word = false;
        }
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            cur = cur.children.computeIfAbsent(word.charAt(i), t-> new TrieNode());
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children.containsKey(word.charAt(i))) {
                cur = cur.children.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children.containsKey(prefix.charAt(i))) {
                cur = cur.children.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}