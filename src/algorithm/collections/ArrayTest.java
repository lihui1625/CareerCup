package algorithm.collections;

import java.util.Arrays;

public class ArrayTest {

  public static void main(String[] args) {
    int[] array = new int[100];
    int[] cloneArray = array.clone();
    int len = array.length;
    int code = array.hashCode();
    int code2 = Arrays.hashCode(array);
  }

}
