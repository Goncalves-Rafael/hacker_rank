package data_structures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NoPrefixSet {
  public static void noPrefix(List<String> words) {
    TrieNode root = new TrieNode();
    root.kids = new HashMap<>();
    TrieNode currentNode, nextNode;

    for(String word : words) {
      Character currentChar = word.charAt(0);
      currentNode = root.kids.get(currentChar);

      if (currentNode == null) {
        currentNode = new TrieNode();
        currentNode.kids = new HashMap<>();
        root.kids.put(currentChar, currentNode);
      }

      for (int i = 1; i < word.length(); i++) {
        currentChar = word.charAt(i);
        if (currentNode.isFinal == true) {
            System.out.println("BAD SET");
            System.out.println(word);
            return;
        }

        nextNode = currentNode.kids.get(currentChar);
        if (nextNode == null) {
          nextNode = new TrieNode();
          nextNode.kids = new HashMap<>();
          currentNode.kids.put(currentChar, nextNode);
        }

        currentNode = nextNode;
      }

      if (currentNode.isFinal || currentNode.kids.size() > 0) {
        System.out.println("BAD SET");
        System.out.println(word);
        return;
      }
      currentNode.isFinal = true;
    }
  }

  private static class TrieNode {
    public boolean isFinal;
    public Map<Character, TrieNode> kids;

    public TrieNode() {}

  }
  
}