package algorithms;

import java.util.List;

public class InsertionSort2 {
  public static void insertionSort2(int n, List<Integer> arr) {
    for (int i = 1; i < n; i++) {
      int selectedIem = arr.get(i);
      int currentIndex = i - 1;

      while (currentIndex >= 0 && arr.get(currentIndex) > selectedIem) {
        arr.set(currentIndex + 1, arr.get(currentIndex));
        currentIndex--;
      }

      arr.set(currentIndex + 1, selectedIem);
      printList(arr);
    }
  }

  public static <T> void printList(List<T> arr) {
    for (T i : arr) {
      System.out.print(i);
      System.out.print(" ");
    }
    System.out.println();
  }
}
