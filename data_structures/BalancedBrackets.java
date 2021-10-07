package data_structures;

import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

// }][}}(}][))]

// hist: }

public class BalancedBrackets {
  public static String isBalanced(String s) {
  // Write your code here
    Deque<Character> bracketsHistory = new LinkedList<>();
    Map<Character, Character> closingBrackers = new HashMap<Character, Character>();
    closingBrackers.put(')', '(');
    closingBrackers.put(']', '[');
    closingBrackers.put('}', '{');

    for (int i = 0; i < s.length(); i++) {
        Character currentChar = s.charAt(i);
        if (closingBrackers.containsKey(currentChar)) {
          if (bracketsHistory.isEmpty() || !bracketsHistory.peek().equals(closingBrackers.get(currentChar))) {
            return "NO";
          }
          bracketsHistory.remove();
        } else {
          bracketsHistory.push(currentChar);
        }
    }

    if (bracketsHistory.isEmpty()) {
      return "YES";
    }

    return "NO";
  }  
}
