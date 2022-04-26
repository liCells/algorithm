/**
 * https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/train/java
 */
public class AbbreviateATwoWordName {
    public static void main(String[] args) {
        assert ("S.H".equals(abbrevName("Sam Harris")));
    }

    public static String abbrevName1(String name) {
        return (name.charAt(0) + "." + name.charAt(name.indexOf(" ") + 1)).toUpperCase();
    }

    public static String abbrevName(String name) {
        String[] arr = name.split(" ");
        return (arr[0].charAt(0) + "." + arr[1].charAt(0)).toUpperCase();
    }
}
