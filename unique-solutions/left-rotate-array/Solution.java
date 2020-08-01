// Question URL: https://www.hackerrank.com/challenges/linkedin-practice-array-left-rotation/problem?h_r=internal-search
// This takes O(N) time and O(1) space. This solution is simple and a novice can also think of this 
// solution in an interview setup.test

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    static Scanner s;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        s = new Scanner(System.in);
        int n, d;
        n = s.nextInt();
        d = s.nextInt();
        int arr[] = new int[n];
        takeInput(arr, n);

        rotateArray(arr, d, n);

        displayInput(arr, n);
    }

    private static void rotateArray(int arr[], int d, int n) {
        d = d%n;
        if (d<=0) return;
        int count = 0, i = n-1, item = arr[n - 1];
        while (count < n) {
            if(count != 0 && count%2 == 0 && n/d == 2 && n%d == 0) {
                i--;
                item = arr[i];
            }
            int position = determinePosition(i, d, n);
            int temp = arr[position];
            arr[position] = item;
            count++;
            item = temp;
            i = position;
        }
    }

    private static int determinePosition(int i, int d, int n) {
        int position = i - d;
        return position < 0 ? n + position : position;
    }

    private static void takeInput(int arr[], int n) {
        for (int i=0; i<n; i++) {
            int temp = s.nextInt();
            arr[i] = temp;
        }
    }

    private static void displayInput(int arr[], int n) {
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
