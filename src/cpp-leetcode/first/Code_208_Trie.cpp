#include <stdbool.h>
#include <stdlib.h>

#include <iostream>

using std::string;

/**
 * trie
 *
 * @since 2020-9-11 Friday 23:41
 */
class Trie {
   private:
    bool isEnd;
    Trie *next[26];

   public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd = false;
        memset(next, 0, sizeof(next));
    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *node = this;
        for (char c : word) {
            if (node->next[c - 'a'] == NULL) {
                node->next[c - 'a'] = new Trie();
            }
            node = node->next[c - 'a'];
        }
        node->isEnd = true;
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *node = this;
        for (char c : word) {
            node = node->next[c - 'a'];
            if (node == NULL)
                return false;
        }
        return node->isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *node = this;
        for (char c : prefix) {
            node = node->next[c - 'a'];
            if (node == NULL)
                return false;
        }
        return true;
    }
};

int main(int argc, char const *argv[]) {
    Trie *obj = new Trie();
	string str = "word";
	string word = "word";
	string prefix = "w";
    obj->insert(str);
    bool b1 = obj->search(word);
    std::cout << b1 << std::endl;
    bool b2 = obj->startsWith(prefix);
    std::cout << b2 << std::endl;
}
