package solutions;

import java.util.ArrayList;

/**
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author harrisonwang
 * 
 */
public class Problem_01 {

  public static String reverseWords(String s) {
    if (s != null) {
      char[] temp = s.toCharArray();
      boolean isStart = true;
      boolean isConSpace = false;
      StringBuilder rSb = new StringBuilder();
      for (int i = 0, lg = temp.length; i < lg; i++) {
        if (temp[i] == ' ') {
          if (!isStart && !isConSpace) {
            rSb.append(' ');
            isConSpace = true;
          }
        } else {
          rSb.append(temp[i]);
          isStart = false;
          isConSpace = false;
        }
      }
      s = rSb.toString();
      if (s.endsWith(" ")) {
        s = s.substring(0, s.length() - 1);
      }
      int spaceIndex = s.indexOf(" ");
      int startIndex = 0;
      ArrayList<String> store = new ArrayList<String>();
      while (spaceIndex != -1) {
        store.add(s.substring(startIndex, spaceIndex));
        store.add(" ");
        startIndex = spaceIndex + 1;
        spaceIndex = s.indexOf(" ", startIndex);
      }
      store.add(s.substring(startIndex, s.length()));
      StringBuilder sb = new StringBuilder();
      for (int i = store.size() - 1; i >= 0; i--) {
        sb.append(store.get(i));
      }
      return sb.toString();
    }
    return s;
  }

}
