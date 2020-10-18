public class Solution1 {
    public static void main(String args[]) {
        // int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        // int arr[] = {-1, 2, -3, 4, 5, 6, -7, -8, -9};
        int arr[] = {-1, 2, -3, 4, 5, -6, -7, -8, -9};
        int n = arr.length;

        rearrange(arr, n);
        display(arr, n);
    }
    
    static void display(int arr[], int n) {
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void rearrange(int arr[], int n) {
        int pivot = setAndGetPivot(arr, n);
        int right = pivot + 1;
        int left = 1;
        while(right < n && left < right && arr[left] < 0) {
            swap(arr, left, right);
            left += 2;
            right++;
        }
    }

    static int setAndGetPivot(int arr[], int n) {
        int i = -1;
        for(int j=0; j<n; j++) {
            if(arr[j] < 0) {
                i++;
                if(i != j) {
                    swap(arr, i, j);
                }
            }
        }

        return i;
    }

    static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}