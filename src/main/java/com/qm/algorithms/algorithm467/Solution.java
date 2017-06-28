package com.qm.algorithms.algorithm467;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wodvpn on 2017/4/26.
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        Map<Character, Integer> cache = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            cache.put(c, 0);
        }
        int sum = 0;
        int startIndex = 0;
        int currentLength = 1;
        for (int endIndex = 0; endIndex < p.length(); ) {
            if (endIndex + 1 < p.length() && isContinuous(p.charAt(endIndex), p.charAt(endIndex + 1))) {
                currentLength++;
                endIndex++;
                while(endIndex + 1 < p.length() && isContinuous(p.charAt(endIndex), p.charAt(endIndex + 1)))
                {
                    currentLength++;
                    endIndex++;
                }
            }else{
                endIndex++;
            }
            int length = currentLength;
            int targetLength = 0;
            int currentIndex = startIndex;
            while (length > 0 && (currentIndex - startIndex < 26)) {
                targetLength = cache.get(p.charAt(currentIndex));
                if (length > targetLength) {
                    sum += length - targetLength;
                    cache.put(p.charAt(currentIndex), length);
                }
                length--;
                currentIndex++;
            }
            startIndex = endIndex;
            currentLength = 1;
        }
        return sum;
    }

    public boolean isContinuous(char a, char b) {
        return b - a == 1 || (a == 'z' && b == 'a');
    }


    @Test
    public void test()
    {
        System.out.println(findSubstringInWraproundString("abc"));
    }
}