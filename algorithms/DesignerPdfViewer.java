package algorithms;

import java.util.List;

class DesignerPdfViewer {

  /*
   * Complete the 'designerPdfViewer' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h
   *  2. STRING word
   */

  public static int designerPdfViewer(List<Integer> h, String word) {
  // Write your code here
      Integer maxHeight = 0;
      for(int i = 0; i < word.length(); i++) {
          int currentHeight = h.get(word.charAt(i) - 'a');
          if (currentHeight > maxHeight) {
              maxHeight = currentHeight;
          }
      }
      return word.length() * maxHeight;
  }

}