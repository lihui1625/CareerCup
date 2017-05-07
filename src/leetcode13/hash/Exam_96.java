package leetcode13.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Exam_96 {

  public static List<Integer> findSubString(String S, String[] L) {
    List<Integer> list = new LinkedList<>();
    int tokenLength = L[0].length();
    int tokenCount = L.length;
    int totalLen = tokenLength * tokenCount;
    HashMap<String, Integer> lMap = new HashMap<>();
    for (String str : L) {
      if (!lMap.containsKey(str)) {
        lMap.put(str, 1);
      } else {
        lMap.put(str, lMap.get(str) + 1);
      }
    }
    for (int i = 0; i < S.length() - totalLen + 1; i++) {
      String str = S.substring(i, i + totalLen);
      int count = 0;
      HashMap<String, Integer> map = new HashMap<>();
      for (int j = 0; j < tokenCount; j++) {
        String token = str.substring(j * tokenLength, (j + 1) * tokenLength);
        if (!map.containsKey(token)) {
          break;
        } else {
          map.put(token, map.get(token) - 1);
          if (map.get(token) >= 0) {
            count++;
          } else {
            break;
          }
        }
      }
      if (count == tokenCount) {
        list.add(i);
      }
    }
    return list;

  }

  public static void main(String[] args) {
    System.out.println(
        findSubString("asdfasadfqwrfdsafasdfsd", new String[] { "s", "d" }));

  }

}
