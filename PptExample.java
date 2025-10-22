import java.util.Scanner;

public class PptExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter another number: ");
        int num2 = sc.nextInt();
        int sum = add(num1, num2);
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum + ".");
	
	String a = sc.nextLine();

	System.out.println("given input id "+a);


    }

    public static int add(int a, int b) {
        return a + b;
    }
}

