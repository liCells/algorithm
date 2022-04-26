/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
 */
public class SpinWords {
    public static void main(String[] args) {
        assert ("Hey wollef sroirraw".equals(spinWords("Hey fellow warriors")));
        System.out.println(spinWords("Hey fellow warriors"));
    }

    public static String spinWords(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sentenceBuilder = new StringBuilder();
        for (String str : arr) {
            if (str.length() > 4) {
                str = new StringBuilder(str).reverse().toString();
            }
            sentenceBuilder.append(str).append(" ");
        }
        sentence = sentenceBuilder.toString();
        return sentence.trim();
    }
}
