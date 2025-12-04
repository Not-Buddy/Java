public class MaxFind {
    public static void main(String[] args) {
        int max = findMax(20, 15);
        System.out.println("Maximum: " + max);
    }

    public static int findMax(int a, int b) {
        return (a > b) ? a : b;
    }
}

