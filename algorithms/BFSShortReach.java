package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BFSShortReach {

  /*
   * Complete the 'bfs' function below.
   *
   * The function is expected to return an INTEGER_ARRAY. The function accepts
   * following parameters: 1. INTEGER n 2. INTEGER m 3. 2D_INTEGER_ARRAY edges 4.
   * INTEGER s
   */
  public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
    Integer result[] = new Integer[n - 1];
    for (int i = 0; i < n - 1; i++) {
      result[i] = -1;
    }
    HashMap<Integer, List<Integer>> mappedEdges = new HashMap<>();
    for (List<Integer> currentEdge : edges) {
      int source = currentEdge.get(0);
      int destination = currentEdge.get(1);
      if (!mappedEdges.containsKey(source)) {
        mappedEdges.put(source, new LinkedList<>());
      }
      mappedEdges.get(source).add(destination);
    }
    HashSet<Integer> visited = new HashSet<>();
    LinkedList<Integer> queue = new LinkedList<>();

    queue.add(s);
    visited.add(s);

    int level = 1;

    while (!queue.isEmpty()) {
      int level_size = queue.size();
      while (level_size > 0) {
        Integer currNode = queue.remove();
        List<Integer> currEdges = mappedEdges.get(currNode);
        if (currEdges != null) {
          for (Integer nextNode : currEdges) {
            if (visited.contains(nextNode)) {
              continue;
            }
  
            visited.add(nextNode);
            result[nextNode - 2] = level * 6;
            queue.add(nextNode);
          }
        }
        level_size--;
      }
      level++;
    }
    return Arrays.asList(result);
  }

  public static void main(String[] args) {
    int n = 5;
    int m = 3;
    List<List<Integer>> edges = new LinkedList<>();
    // 5 3
    // 1 2
    // 1 3
    // 3 4
    Integer[] arr1 = {1, 2};
    Integer[] arr2 = {1, 3};
    Integer[] arr3 = {3, 4};
    edges.add(Arrays.asList(arr1));
    edges.add(Arrays.asList(arr2));
    edges.add(Arrays.asList(arr3));
    int s = 1;
    System.out.println(bfs(n,m, edges, s));
  }
}
