/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Test {
	public static void main (String[] args) {
		//code
		
		int noOfTests = 0;
		Scanner sc = new Scanner(System.in);
		
		noOfTests = sc.nextInt();
		
		while(noOfTests-- > 0) {
		    int size = sc.nextInt();
		    int sum = sc.nextInt();
		    
		    int[] nums = new int[size];
		    takeNumsInput(nums, size, sc);
		    
		    printSubarrayIndices(nums, size, sum);
		    
		  //  displayNums(nums, size);
		    
		}
	}
	
	static void printSubarrayIndices(int nums[], int size, int sum) {
	    if(sum < 0) {
	        System.out.println("-1");
	    }
        int left = 0, right = 0, tempSum = 0;
        boolean canRightBeAdded = true;
	    while(left <= right && right < size) {
	        if(tempSum == sum) {
	            break;
	        }
	        else if(tempSum < sum) {
                if(canRightBeAdded) tempSum += nums[right];
                else break;

                if(right + 1 == size) {
                    canRightBeAdded = false;   
                }
                else right++;
	        }
	        else {
	            tempSum -= nums[left++];
	        }
	        
	        //System.out.println("left: " + left + " right: " + right + " tempSum: " + tempSum);
	    }
	    if(!canRightBeAdded) right++;
	    if(tempSum == sum) {
	        System.out.println((left+1) + " " + right);
	    }
	    else System.out.println("-1");
	}
	
	static void takeNumsInput(int nums[], int size, Scanner sc) {
	    for(int i=0; i<size; i++) {
	        nums[i] = sc.nextInt();
	    }
	}
}