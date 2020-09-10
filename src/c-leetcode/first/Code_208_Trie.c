/* trie

   @since 2020-9-10 Thursday
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct trie
{
    bool isEnd;
    struct trie *next[26];
} Trie;

/** Initialize your data structure here. */

Trie *trieCreate()
{
    Trie *res = calloc(1, sizeof(Trie));
    res->isEnd = false;
    return res;
}

/** Inserts a word into the trie. */
void trieInsert(Trie *obj, char *word)
{
    Trie *node = obj;
    for (; *word; word++)
    {
        if (node->next[*word - 'a'] == 0)
            node->next[*word - 'a'] = trieCreate();
        node = node->next[*word - 'a'];
    }
    node->isEnd = true;
}

/** Returns if the word is in the trie. */
bool trieSearch(Trie *obj, char *word)
{
    Trie *node = obj;
    for (; *word; word++)
    {
        if (node->next[*word - 'a'] == 0)
            return false;
        else
            node = node->next[*word - 'a'];
    }
    return node->isEnd;
}

/** Returns if there is any word in the trie that starts with the given prefix. */
bool trieStartsWith(Trie *obj, char *prefix)
{
    Trie *node = obj;
    for (; *prefix; prefix++)
    {
        if (node->next[*prefix - 'a'] == 0)
            return false;
        else
            node = node->next[*prefix - 'a'];
    }
    return true;
}

void trieFree(Trie *obj)
{
    free(obj);
}

int main(int argc, char const *argv[])
{
    // char *word = "word";
    char *word = "word";
    char *search = "wo";
    char *prefix = "w";
    Trie *obj = trieCreate();
    trieInsert(obj, word);
    bool param_2 = trieSearch(obj, search);
    printf("res p2: %d'\n", param_2);
    bool param_3 = trieStartsWith(obj, prefix);
    printf("res p3: %d'\n", param_3);
    trieFree(obj);
}
