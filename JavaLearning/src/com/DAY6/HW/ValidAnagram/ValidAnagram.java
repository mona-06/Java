package com.DAY6.HW.ValidAnagram;

import java.util.HashMap;

class AnagramChecker {

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
public class ValidAnagram {
    public static void main(String[] args) {
        String s1="Anagrams";
        String s2="Anagrams";
        boolean result= AnagramChecker.isAnagram(s1,s2);
        System.out.println(result);
    }
}
