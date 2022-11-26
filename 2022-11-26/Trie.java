/**
https://leetcode.com/problems/implement-trie-prefix-tree/

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith. */

class Trie {
  // 定义一个root节点
  TrieNode root;

  class TrieNode {
    // 记录是否是一个单词的结尾
    boolean isWord;
    // 记录子节点
    TrieNode[] children;

    public TrieNode() {
      this.isWord = false;
      // 26个字母
      children = new TrieNode[26];
    }
  }

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    // 定义一个指针 指向root
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      // 如果没有值 初始化
      if (curr.children[index] == null) {
        curr.children[index] = new TrieNode();
      }
      curr = curr.children[index];
    }
    // 最后设置 isWord;
    curr.isWord = true;
  }

  public boolean search(String word) {
    // 定义一个指针 指向root
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      // 如果没有值 说明不存在 直接返回false
      if (curr.children[index] == null) {
        return false;
      }
      curr = curr.children[index];
    }
    // 遍历完成 返回isWord属性
    return curr.isWord;
  }

  public boolean startsWith(String prefix) {
    // 定义一个指针 指向root
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      int index = ch - 'a';
      // 如果没有值 说明不存在 直接返回false
      if (curr.children[index] == null) {
        return false;
      }
      curr = curr.children[index];
    }
    // 遍历完成直接返回true
    return true;
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
