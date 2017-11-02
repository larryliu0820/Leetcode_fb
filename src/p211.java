/**
 * Created by Larry Liu on 10/31/2017.
 * 211. Add and Search Word - Data structure design
 */
public class p211 {
    class TrieNode {
        boolean isWord;
        TrieNode[] neighbors;
        TrieNode() {
            isWord = false;
            neighbors = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public p211() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode itr = root;
        for (char c: word.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) {
                itr.neighbors[c-'a'] = new TrieNode();
            }
            itr = itr.neighbors[c-'a'];
        }
        itr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.neighbors[i] != null && searchHelper(word, index + 1, node.neighbors[i])) return true;
            }
        } else {
            return node.neighbors[word.charAt(index)-'a'] != null &&
                    searchHelper(word, index + 1, node.neighbors[word.charAt(index)-'a']);
        }
        return false;
    }
}
