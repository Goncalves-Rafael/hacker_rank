package algorithms;

import java.util.List;

public class InsertionSort1 {
  public static void insertionSort1(int n, List<Integer> arr) {
    int selectedIem = arr.get(n - 1);
    int currentIndex = n - 2;

    while (currentIndex >= 0 && arr.get(currentIndex) > selectedIem) {
      arr.set(currentIndex + 1, arr.get(currentIndex));
      currentIndex--;
      printList(arr);
    }

    arr.set(currentIndex + 1, selectedIem);
    printList(arr);
  }

  public static <T> void printList(List<T> arr) {
    for (T i : arr) {
      System.out.print(i);
      System.out.print(" ");
    }
    System.out.println();
  }
}
