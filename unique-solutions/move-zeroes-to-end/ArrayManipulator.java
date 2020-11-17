public class ArrayManipulator {
	public static void main(String args[]) {
        // int nums[] = {1, 2, 0, 0, 0, 4, 3, 0, 5, 8};
        // int nums[] = {1, 2, 0, 0, 0, 4, 3, 0, 5, 0};
        // int nums[] = {1, 2, 0, 4, 3, 0, 5, 0};
        // int nums[] = {0, 0, 0, 0, 0, 0};
        // int nums[] = {1, 2, 4, 3, 5, 8};
        // int nums[] = {};
        // int nums[] = {1};
        // int nums[] = {0};
        // int nums[] = {1, 0};
        int nums[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        // int nums[] = {0, 1};
		moveZeroesToEnd(nums);  
		displayNums(nums);
    }

    static void displayNums(int nums[]) {
        int length = nums.length;
        for (int i=0; i<length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static void moveZeroesToEnd(int nums[]) {
        int firstNonZeroIndex=0, zeroIndex = 0, length = nums.length;
        for(int currentIndex=0; currentIndex < length; currentIndex++) {

            if(zeroIndex != firstNonZeroIndex && nums[currentIndex] != 0) {
                swap(nums, currentIndex, zeroIndex);
                zeroIndex++;
                firstNonZeroIndex++;
            }
            else if(nums[currentIndex] == 0 && zeroIndex == firstNonZeroIndex) {
                zeroIndex = currentIndex;
                firstNonZeroIndex = currentIndex + 1;
            }
        }
    }

    static void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
