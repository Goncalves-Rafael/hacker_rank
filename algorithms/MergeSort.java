package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

  public static void sort(int[] arr) {
    int[] temp = new int[arr.length];
    sort(arr, temp, 0, arr.length - 1);
  }
  
  public static void sort(int[] arr, int[] temp, int left, int right) {
    if (left < right) {
      int middle = left + (right - left)/2;

      sort(arr, temp, left, middle);
      sort(arr, temp, middle + 1, right);

      merge(arr, temp, left, middle, right);
    }
  }

  public static void merge(int[] arr, int[] temp, int left, int middle, int right) {
    int i = left, j = middle + 1, k = left;

    while (i <= middle && j <= right) {
      if (arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i <= middle) {
      temp[k] = arr[i];
      i++;
      k++;
    }

    while (j <= right) {
      temp[k] = arr[j];
      j++;
      k++;
    }

    System.arraycopy(temp, left, arr, left, right - left + 1);
  }

  public static void main(String args[]) {
    int[] test = {5,2,3,1,6,8,7};

    sort(test);
    System.out.println(test);
  }
}
