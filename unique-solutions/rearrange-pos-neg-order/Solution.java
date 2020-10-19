public class Solution {
    public static void main(String args[]) {
        int arr[] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}; 
        // int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4}; 
        // int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4}; 
        // int arr[] = {-5, 3, -4, 2, -7, -1 , -8, -9, 1 , -4}; 
        // int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; 
        int len = arr.length;

        rearrange(arr, len);
        display(arr, len);
    }

    static void display(int arr[], int length) {
        for(int i=0; i<length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void rearrange(int arr[], int length) {
        int outOfPlace = -1;
        for(int i=0; i<length; i++) {
            if(outOfPlace >= 0) {
                if((arr[outOfPlace] > 0 && arr[i] < 0) || (arr[outOfPlace] < 0 && arr[i] > 0)) {
                    rightRotate(arr, outOfPlace, i);
                    if(i - outOfPlace > 2) {
                        outOfPlace += 2;
                    }
                    else outOfPlace = -1;
                }
            }

            if(outOfPlace == -1) {
                if((arr[i] > 0 && i%2 == 0) || (arr[i] < 0 && i%2 == 1)) {
                    outOfPlace = i;
                }
            }
        }
    }

    static void rightRotate(int arr[], int start, int end) {
        int temp = arr[end];
        for(int i=end; i>start; i--) {
            arr[i] = arr[i-1];
        }
        arr[start] = temp;
    }
}