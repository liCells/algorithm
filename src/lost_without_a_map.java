import java.util.Arrays;

/**
 * https://www.codewars.com/kata/57f781872e3d8ca2a000007e/train/java
 */
public class lost_without_a_map {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(map(new int[]{1, 2, 3})));
    }

    public static int[] map(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
        return arr;
    }
}
