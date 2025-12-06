import java.util.Scanner;

public class Recur2 {
    public static void recur(int n)
    {
        if(n==1)
            return;
        recur(--n);
        System.out.println(n);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your value of n");
        int n = sc.nextInt();
        recur(n);
        sc.close();
    }
}
