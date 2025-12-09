import java.util.Scanner;

public class SearchingAlgorithms {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
       
    public void linearSearch(int arr[], int len)
    {
        int i,flag=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be searched:");
        int item = sc.nextInt();
        for(i=0;i<len;i++)
        {
            if(arr[i] == item)
            {
                System.out.println("Element found at position: " + i);
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("Element not found");    
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}