package leetcode.first;

/**
 * 实现trie树
 *
 * @since 2020-6-28  Sunday 15:58
 */
public class Code_208_Trie {
    public static void main(String[] args) {
        String word = "word", prefix1 = "w", prefix2 = "l";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix1);
        boolean param_4 = obj.startsWith(prefix2);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (!node.containsKey(curCh)) {
                node.put(curCh, new TrieNode());
            }
            node = node.get(curCh);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (node.containsKey(curCh)) {
                node = node.get(curCh);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        this.links = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
