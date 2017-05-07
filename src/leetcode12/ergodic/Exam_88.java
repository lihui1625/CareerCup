package leetcode12.ergodic;

import java.util.Arrays;
import java.util.Random;

public class Exam_88 {

  public static boolean findWord(char[][] dict, String word) {
    int m = dict.length;
    int n = dict[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dict[i][j] == word.charAt(0)) {
          boolean[][] visited = new boolean[m][n];
          if (dfs(dict, visited, word, i, j, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private static boolean dfs(char[][] dict, boolean[][] visited, String word,
      int x, int y, int wordIndex) {

    if (x < 0 || y < 0 || x > dict.length - 1 || y > dict[0].length - 1
        || wordIndex < 0 || wordIndex > word.length() - 1) {
      throw new RuntimeException("error!");
    }
    if (dict[x][y] != word.charAt(wordIndex)) {
      return false;
    }
    if (wordIndex == word.length() - 1) {
      return true;
    }
    visited[x][y] = true;

    boolean result1 = false;
    if (x >= 1 && !visited[x - 1][y]
        && dict[x - 1][y] != word.charAt(wordIndex)) {
      result1 = dfs(dict, visited, word, x - 1, y, wordIndex + 1);
    }
    if (result1) {
      return true;
    }

    boolean result2 = false;
    if (x < dict.length - 1 && !visited[x + 1][y]
        && dict[x + 1][y] != word.charAt(wordIndex)) {
      result2 = dfs(dict, visited, word, x + 1, y, wordIndex + 1);
    }
    if (result2) {
      return result2;
    }

    boolean result3 = false;
    if (y >= 1 && !visited[x][y - 1]
        && dict[x][y - 1] != word.charAt(wordIndex)) {
      result3 = dfs(dict, visited, word, x, y - 1, wordIndex + 1);
    }
    if (result3) {
      return result3;
    }

    boolean result4 = false;
    if (y < dict[0].length - 1 && !visited[x][y + 1]
        && dict[x][y + 1] != word.charAt(wordIndex)) {
      result4 = dfs(dict, visited, word, x, y + 1, wordIndex + 1);
    }
    if (result4) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 10;
    char[][] im = new char[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        im[i][j] = (char) (r.nextInt(26) + 'A');
      }
    }
    for (int i = 0; i < N; i++) {
      System.out.println(Arrays.toString(im[i]));

    }
    System.out.println("" + im[8][9] + im[9][9] + im[9][8] + im[8][8] + ":"
        + findWord(im, "" + im[8][9] + im[9][9] + im[9][8] + im[8][8]));
    //
    // for (int i = 0; i < N; i++) {
    // System.out.println(Arrays.toString(im[i]));
    //
    // }

  }

}
