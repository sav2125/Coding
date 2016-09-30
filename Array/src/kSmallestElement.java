/**
 * Created by siddharthvarshney on 9/28/16.
 */
public class kSmallestElement {
    static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int arr[], int low, int high)
    {
        int i = low;
        int x = arr[high];
        for(int j = low; j < high; j++)
        {
            if(arr[j] <= x)
            {
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,high);
        return i;
    }
    static int randomPartition(int arr[], int low, int high)
    {
        int n = high - low + 1;
        int pivot = ((int)Math.random() % n);
        swap(arr, low + pivot, high);
        return partition(arr,low,high);
    }
    static int kthSmallest(int arr[], int low, int high, int k)
    {
        if(k > 0 && k <= high - low + 1)
        {
            int pos = randomPartition(arr, low, high);
            int n = pos - low + 1;
            if(n == k)
                return arr[pos];
            if(n > k)
            {
                return kthSmallest(arr, low, pos - 1, k);
            }
            else
            {
                return kthSmallest(arr, pos + 1, high,k - n);
            }
        }
        return Integer.MAX_VALUE;
    }
     public static void main(String args[])
    {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int n = arr.length;
        int k = 3;
        int ans = kthSmallest(arr, 0 , n -1, k);
        System.out.println(ans);
        int x = 0;
    }
}
