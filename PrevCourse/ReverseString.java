public class ReverseString {
    public static void main(String[] args) {
        String reversed = reverseString("hello");
        System.out.println("Reversed: " + reversed);
    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }
}

