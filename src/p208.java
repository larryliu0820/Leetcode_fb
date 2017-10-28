/**
 * Created by mengwliu on 10/27/17.
 * 208. Implement Trie (Prefix Tree)
 */
public class p208 {
    class TrieNode {
        boolean isWord;
        TrieNode[] neighbors;
        TrieNode() {
            neighbors = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public p208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode itr = root;
        for (char c: word.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) {
                itr.neighbors[c-'a'] = new TrieNode();
            }
            itr = itr.neighbors[c-'a'];
        }
        itr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode itr = root;
        for (char c: word.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) return false;
            itr = itr.neighbors[c-'a'];
        }
        return itr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode itr = root;
        for (char c: prefix.toCharArray()) {
            if (itr.neighbors[c-'a'] == null) return false;
            itr = itr.neighbors[c-'a'];
        }
        return true;
    }
}
