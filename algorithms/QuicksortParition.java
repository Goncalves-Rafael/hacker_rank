package algorithms;

import java.util.List;

public class QuicksortParition {
  public static List<Integer> quicksort(List<Integer> arr) {
    int left = 0;
    int right = arr.size() - 2;
    Integer pivot = arr.get(0);
    swap(arr, 0, right + 1);
    
    while (left < right) {
      if (arr.get(left) < pivot) {
        left++;
      } else if (arr.get(right) >= pivot) {
        right--;
      } else {
        swap(arr, left, right);
        left++;
      }
    }

    swap(arr, left, arr.size() - 1);
    return arr;
  }

  public static void swap(List<Integer> arr, int a, int b) {
    Integer temp = arr.get(a);
    arr.set(a, arr.get(b));
    arr.set(b, temp);
  }

}
