package org.practice.sorting;

import java.util.Arrays;

/*
* divide-and-conquer approach
 */
public class MergeSort {
    public static int[] divide(int[] inputArr){
      if(inputArr.length == 1)
          return inputArr;
      int mid = inputArr.length/2;
      int[] left = divide(Arrays.copyOfRange(inputArr, 0, mid));
      int[] right = divide(Arrays.copyOfRange(inputArr,mid,inputArr.length));

     return conquer(left, right);
    }

    public static int[] conquer(int[] left, int[] right){
        int[] joinedArr = new int[left.length+right.length];
        int i=0, j=0, k = 0;
        while(left.length > i && right.length > j){
            if(left[i] < right[j]){
                joinedArr[k] = left[i];
                i++;
                k++;
            } else {
                joinedArr[k] = right[j];
                j++;
                k++;
            }
        }

        while (left.length != i){
            joinedArr[k] = left[i];
            i++;
            k++;
        }

        while (right.length != j){
            joinedArr[k] = right[j];
            j++;
            k++;
        }
        return joinedArr;
    }
}
