package com.qm.mianshi;

import java.util.BitSet;

/**
 * Created by wodvpn on 2017/6/6.
 */
public class TestBitMap {

    public static void main(String[] args) {
        int[] intArray = {4, 7, 2, 5, 3};
        BitSet bitSet = new BitSet(8);
        for (int i = 0; i < intArray.length; i++) {
            bitSet.set(intArray[i], true);
        }
        System.out.println(bitSet);
        System.out.println(bitSet.get(0));
    }
}
