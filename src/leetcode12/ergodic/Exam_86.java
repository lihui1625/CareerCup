package leetcode12.ergodic;

import java.util.Arrays;
import java.util.Random;

public class Exam_86 {

  public static int linkCount(int[][] im) {
    int m = im.length;
    int n = im[0].length;
    boolean[][] visited = new boolean[m][n];

    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        if (im[i][j] == 0 && !visited[i][j]) {
          dfs(im, visited, i, j);
          count++;
        }
      }
    }

    return count;
  }

  private static void dfs(int[][] im, boolean[][] visited, int i, int j) {
    if (i < 0 || j < 0 || i >= im.length || j >= im[0].length) {
      return;
    }
    if (im[i][j] != 0 || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    dfs(im, visited, i - 1, j);
    dfs(im, visited, i + 1, j);
    dfs(im, visited, i, j - 1);
    dfs(im, visited, i, j + 1);
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 10;
    int[][] im = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        im[i][j] = r.nextInt(2);
      }
    }
    for (int i = 0; i < N; i++) {
      System.out.println(Arrays.toString(im[i]));

    }
    System.out.println(linkCount(im));

  }

}
