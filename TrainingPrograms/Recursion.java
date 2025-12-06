import java.util.Scanner;

public class Recursion {
    
    public static int factorial(int n)
    {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter n that you want to calculate for factorial");
        
        int n = sc.nextInt();
        System.out.println(factorial(n));
        sc.close();
        }
    }