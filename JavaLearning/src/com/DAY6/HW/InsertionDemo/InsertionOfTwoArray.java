package com.DAY6.HW.InsertionDemo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Intersection {
    static int[] findIntersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] output = new int[result.size()];
        int i = 0;
        for (int num : result) {
            output[i++] = num;
        }
        return output;
    }
}

public class InsertionOfTwoArray {
    public static void  main(String[] args){
        int[] num1 = {1,2,3,3};
        int[] nums2 = {2,3,4};
        int[] result = Intersection.findIntersection(num1, nums2);
        System.out.println("Intersection result:"+Arrays.toString(result));

    }
}
