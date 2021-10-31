package data_structures;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QHeap1 {
  private static final int ADD_ELEMENT = 1;
  private static final int REMOVE_ELEMENT = 2;
  private static final int PRINT_MINIMUM = 3;
  public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scanner = new Scanner(System.in);
      int q = Integer.parseInt(scanner.nextLine());
      Comparator<Integer> ascending = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
      };
      PriorityQueue<Integer> heap = new PriorityQueue<Integer>(ascending);
      while (q > 0) {
          String[] input = scanner.nextLine().split(" ");
          performOperation(Integer.valueOf(input[0]), input.length > 1 ? Integer.valueOf(input[1]) : 0, heap);
          q--;
      }
      scanner.close();
  }
  
  public static void performOperation(int code, int data, PriorityQueue<Integer> heap) {
      switch (code) {
        case(ADD_ELEMENT):
          heap.add(data);
          break;
        case(REMOVE_ELEMENT):
          heap.remove(data);
          break;
        case(PRINT_MINIMUM):
          System.out.println(heap.peek());
          break;
      }
  }
}
