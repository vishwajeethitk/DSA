public class Solution {
    public static void main(String args[]) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        // int arr[] = {2, -1, 4, -3, 5, -7, 6, 8, 9};
        // int arr[] = {1, -2, 3, -4, -5, -6, 7, -8, -9};
        int length = arr.length;

        rearrange(arr, length);

        displayArr(arr, length);
    }

    public static void displayArr(int arr[], int length) {
        for(int i=0; i<length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int findNumOfPositives(int arr[], int length) {
        int numOfPositives = 0;
        for(int i=0; i<length; i++) {
            if (arr[i] > 0) numOfPositives++;
        }
        return numOfPositives;
    }

    public static void rearrange(int arr[], int length) {
        int numOfPositives = findNumOfPositives(arr, length);
        int numOfNegatives = length - numOfPositives;
        
        if(numOfNegatives == 0 || numOfPositives == 0) return;

        int compareFactor = 1, continuousIndex = 0;
        if(numOfNegatives > numOfPositives) {
            compareFactor = -1;
            continuousIndex = (numOfPositives * 2) - 1;
        }
        else continuousIndex = numOfNegatives * 2;

        if(isArrangementCorrect(arr, length, compareFactor, continuousIndex)) return;
        processArray(arr, length, compareFactor, continuousIndex);
    }

    public static boolean isArrangementCorrect(int arr[], int length, int compareFactor, int continuousIndex) {
        for (int i=0; i<continuousIndex; i++) {
            if((i%2 == 0 && arr[i] < 0) || (i%2 != 0 && arr[i] > 0)) return false;
        }
        for (int i=continuousIndex; i<length; i++) {
            if((arr[i]*compareFactor) < 0) return false;
        }

        return true;
    }

    public static void processArray(int arr[], int length, int compareFactor, int continuousIndex) {
        processContinuousPart(arr, length, compareFactor, continuousIndex);
        processRest(arr, length, continuousIndex);
    }

    public static void processContinuousPart(int arr[], int length, int compareFactor, int continuousIndex) {
        int j=continuousIndex;
        for(int i=length-1; i>=continuousIndex; i--) {
            if(arr[i]*compareFactor < 0) {
                for(j=j-1; j>=0; j--) {
                    if(arr[j]*compareFactor > 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public static void processRest(int arr[], int length, int continuousIndex) {
        for(int i=continuousIndex-1; i>=0; i--) {
            if(i%2 == 0 && arr[i] < 0) {
                for(int j=i-1; j>=0; j--) {
                    if(arr[j] > 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
            else if(i%2 != 0 && arr[i]>0) {
                for(int j=i-1; j>=0; j--) {
                    if(arr[j] < 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}