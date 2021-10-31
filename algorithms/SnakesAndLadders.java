package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SnakesAndLadders {
  public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
    // Write your code here
    HashMap<Integer, Integer> snakesAndLadders = new HashMap<>();
    for (List<Integer> ladder : ladders) {
      snakesAndLadders.put(ladder.get(0), ladder.get(1));
    }
    for (List<Integer> snake : snakes) {
      snakesAndLadders.put(snake.get(0), snake.get(1));
    }
    List<List<Integer>> graph = new LinkedList<>();
    graph.add(null);
    for (int i = 1; i < 101; i++) {
      insertEdges(graph, snakesAndLadders, i);
    }

    List<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(1);
    int level = 0;
    while(!queue.isEmpty()) {
      int levelSize = queue.size();
      while(levelSize > 0) {
        Integer curr = queue.remove(0);
        if (curr == 100) {
          return level;
        }
        if (!visited.contains(curr)) {
          visited.add(curr);
          for (Integer next : graph.get(curr)) {
            if (!visited.contains(next)) {
              queue.add(next);
            }
          }
        }
        levelSize--;
      }
      level++;
    }
    return -1;
  }

  public static void insertEdges(List<List<Integer>> graph, HashMap<Integer, Integer> snakesAndLadders, int currentNode) {
    graph.add(new LinkedList<>());
    for (int i = 1; i < 7 && currentNode + i < 101; i++) {
      if (snakesAndLadders.containsKey(currentNode + i)) {
        graph.get(currentNode).add(snakesAndLadders.get(currentNode + i));
      } else {
        graph.get(currentNode).add(currentNode + i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> ladders = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
          try {
            ladders.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList()));
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> snakes = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
          try {
            snakes.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList()));
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        int result = quickestWayUp(ladders, snakes);
        int i = 0;
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
