package leetcode.second;

/**
 * trie
 * 
 * @since 2020-8-14 Friday 15:04 - 15:42
 */
public class Code_208_Trie {
    public static void main(final String[] args) {
        final Trie trie = new Trie();
        trie.insert("length");
        trie.insert("apple");
        System.out.println(trie.search("length"));
        System.out.println(trie.search("lengthh"));
        System.out.println(trie.startsWith("len"));
        System.out.println(trie.startsWith("leh"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {
    private final TrieNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(final String word) {
        TrieNode n = node;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (!n.containsKey(c)) {
                n = n.put(c);
            } else {
                n = n.get(c);
            }
        }
        n.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(final String word) {
        TrieNode n = searchPrefix(word);
        return n == null ? false : n.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(final String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(final String prefix) {
        TrieNode n = node;
        for (int i = 0; i < prefix.length(); i++) {
            final char c = prefix.charAt(i);
            if (!n.containsKey(c)) {
                return null;
            } else {
                n = n.get(c);
            }
        }
        return n;
    }

    private static final class TrieNode {
        private final TrieNode[] links;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[26];
        }

        TrieNode put(final char c) {
            final TrieNode n = new TrieNode();
            links[c - 'a'] = n;
            return n;
        }

        TrieNode get(final char c) {
            return links[c - 'a'];
        }

        boolean containsKey(final char c) {
            return links[c - 'a'] != null;
        }

        boolean isEnd() {
            return isEnd;
        }

        void setEnd(final boolean end) {
            isEnd = end;
        }
    }
}