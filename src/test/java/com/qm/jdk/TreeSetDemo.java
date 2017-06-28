package com.qm.jdk;

/**
 * Created by wodvpn on 2017/4/24.
 */
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // creating a TreeSet
        TreeSet <Integer>treeadd = new TreeSet<Integer>();

        // adding in the tree set
        treeadd.add(12);
        treeadd.add(11);
        treeadd.add(16);
        treeadd.add(15);
        treeadd.add(14);
        treeadd.add(13);

        // getting ceiling value for 13
        System.out.println("Ceiling value for 13: "+treeadd.ceiling(13));
    }
}
