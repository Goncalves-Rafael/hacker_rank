package algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
  public static List<Integer> sort(List<Integer> arr, int left, int right) {
    if (left >= right) {
      return arr;
    }
    Integer pivot = arr.get(left);
    int originalRight = right;
    int originalLeft = left;
    swap(arr, left, right);
    right--;

    while (left <= right) {
      if (arr.get(left) < pivot) {
        left++;
      } else if (arr.get(right) >= pivot) {
        right--;
      } else {
        swap(arr, left, right);
      }
    }

    swap(arr, left, originalRight);

    sort(arr, originalLeft, left - 1);
    sort(arr, left + 1, originalRight);
    return arr;
  }

  public static void swap(List<Integer> arr, int a, int b) {
    Integer temp = arr.get(a);
    arr.set(a, arr.get(b));
    arr.set(b, temp);
  }

  public static void main(String args[]) {
    List<Integer> test = new ArrayList<>();

    test.add(5);
    test.add(2);
    test.add(3);
    test.add(1);
    test.add(6);
    test.add(8);
    test.add(7);

    sort(test, 0, test.size() - 1);
  }
}
