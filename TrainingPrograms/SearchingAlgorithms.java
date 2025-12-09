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
    
    public static int binarySearchRecursive(int arr[], int left, int right, int item)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == item)
                return mid;

            if (arr[mid] > item)
                return binarySearchRecursive(arr, left, mid - 1, item);

            return binarySearchRecursive(arr, mid + 1, right, item);
        }

        return -1;
    }

    public static int TernarySearch(int arr[], int left, int right, int item)
    {

        //Time Complexity: O(logn base 3)
        if (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == item)
                return mid1;
            if (arr[mid2] == item)
                return mid2;

            if (item < arr[mid1])
                return TernarySearch(arr, left, mid1 - 1, item);
            else if (item > arr[mid2])
                return TernarySearch(arr, mid2 + 1, right, item);
            else
                return TernarySearch(arr, mid1 + 1, mid2 - 1, item);
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