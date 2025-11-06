package com.DAY5.HW.ContainsDuplicate;

import java.util.*;

 class Duplicates {
     static boolean hasDuplicate(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
         for (int num : nums) {
             if (set.contains(num)) {
                 return true;
             }
             set.add(num);
         }
         return false;
     }
 }
public class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums = {1,2,3,3};
        boolean result=Duplicates.hasDuplicate(nums);
        System.out.println(result);
    }
}
