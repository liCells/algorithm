import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReversedStrings {

    public static void main(String[] args) {
        System.out.println(solution("world"));
    }

    public static String solution1(String str) {
        // Your code here...
        String[] arr = str.split("");
        str = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            str += arr[i];
        }
        return str;
    }

    public static String solution2(String str) {
        // Your code here...
        char[] arr = str.toCharArray();
        str = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            str += arr[i];
        }
        return str;
    }

    public static String solution3(String str) {
        // Your code here...
        List<String> list = new ArrayList<>(Arrays.stream(str.split("")).toList());
        Collections.reverse(list);
        return String.join("", list);
    }

    public static String solution4(String str) {
        // Your code here...
        return new StringBuilder(str).reverse().toString();
    }

    public static String solution(String str) {
        // Your code here...
        String string = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            string += str.charAt(i);
        }
        return string;
    }
}
