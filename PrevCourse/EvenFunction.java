public class EvenFunction {
    public static void main(String[] args) {
        boolean isEven = checkEven(4);
        System.out.println("Is even: " + isEven);
    }

    public static boolean checkEven(int number) {
        return number % 2 == 0;
    }
}

