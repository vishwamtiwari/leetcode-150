class WordDictionary {
    WordDictionary[] children;
    boolean isWord;

    public WordDictionary() {
        this.children = new WordDictionary[26];

    }

    public void addWord(String word) {
        WordDictionary current = this;

        for (char c: word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null)
                current.children[index] = new WordDictionary();

            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, this);
    }

    private boolean searchHelper(String word, int index, WordDictionary current) {
        if (index == word.length())
            return current.isWord;

        char c = word.charAt(index);

        if (c == '.') {
            for (WordDictionary child: current.children) {
                if (child != null && searchHelper(word, index + 1, child)) {
                    return true;
                }
            }

            return false;
        }

        int childIndex = c - 'a';

        if (current.children[childIndex] == null)
            return false;

        return searchHelper(word, index+1, current.children[childIndex]);

    }
}