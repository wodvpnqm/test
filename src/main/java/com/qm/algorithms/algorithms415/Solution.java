package com.qm.algorithms.algorithms415;

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for(int i= num1.length()-1,  j=num2.length()-1;i>-1||j>-1||carry==1;i--,j--){
            int x = i<0?0:num1.charAt(i)-'0';
            int y = j<0?0:num2.charAt(j)-'0';
            s.append((x+y+carry)%10);
            carry =(x+y+carry)/10;
        }
        return s.reverse().toString();
    }
}