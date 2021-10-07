package data_structures;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
  /*
  * Complete the 'rotLeft' function below.
  *
  * The function is expected to return an INTEGER_ARRAY.
  * The function accepts following parameters:
  *  1. INTEGER_ARRAY a
  *  2. INTEGER d
  */

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    int numberOfElements = a.size();
    int numberOfRotations = d % numberOfElements;
    if (numberOfRotations == 0 || numberOfElements == 0) {
        return a;
    }
    List<Integer> rotatedArray = new ArrayList<>(numberOfElements);
    for (int i = 0; i < numberOfElements; i++) {
        int originalIndexFromI = (numberOfRotations + i) % numberOfElements;
        rotatedArray.add(a.get(originalIndexFromI));
    }
    
    return rotatedArray;
  }
}
