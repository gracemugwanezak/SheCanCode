public class Palindrome {
    public static String reverse(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        if (word.equalsIgnoreCase(reversed)) {
            return reversed.toLowerCase() + "  is palindrome";
        }
        else {
            return word + " is not palindrome";
        }
    }
    public static void main(String[] args){
        String myWord = "air";
        System.out.println(reverse(myWord));


    }
}