public class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        this.children = new Trie[26];
        this.isWord = false;
    }

    public void insert(String word) {
        Trie current = this;

        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        Trie current = this;

        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;

        for (char c: prefix.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null)
                return false;

            current = current.children[index];
        }

        return true;
    }
}