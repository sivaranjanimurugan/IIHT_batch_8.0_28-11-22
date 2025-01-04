package org.practice;

import org.practice.sorting.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
           int[] inputArr = {5,4,2,0,7,3};
           System.out.println(Arrays.toString(MergeSort.divide(inputArr)));
        }
}