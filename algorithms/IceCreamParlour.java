package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamParlour {
  public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> flavorsMatch = new HashMap<>();
    for (Integer i = 0; i < arr.size(); i++) {
      Integer currentFlavorPrice = arr.get(i);
      Integer expectedFlavorPriceMatch = m - currentFlavorPrice;
      if (flavorsMatch.containsKey(expectedFlavorPriceMatch)) {
        result.add(flavorsMatch.get(expectedFlavorPriceMatch) + 1);
        result.add(i + 1);
        break;
      }
      flavorsMatch.put(currentFlavorPrice, i);
    }
    return result;
  }
}
