package com.qm.mianshi;

/**
 * Created by wodvpn on 2017/6/6.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class GetPopularQuery {

    public static void main(String args[]) {
        GetPopularQuery gpq = new GetPopularQuery();
        Map<String, Integer> content = new HashMap<String, Integer>();
        gpq.buildHashMap(content);
        // gpq.printHashMap(content);
        int k = 10;
        gpq.findPopularQuery(content, k);

    }

    // 第一步：创建hashmap
    public void buildHashMap(Map<String, Integer> content) {
        try {
            FileReader reader = new FileReader("words.txt");
            BufferedReader br = new BufferedReader(reader);

            String s = null;
            while ((s = br.readLine()) != null) {
                int count;
                if (!content.containsKey(s))// 如果不存在这个key那么就插入这个key，其值为1
                {
                    content.put(s, 1);
                } else// 修改hashmpa中的值，直接使用put覆盖，不需要remove后再put
                {
                    count = content.get(s);
                    content.put(s, count + 1);
                }
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 打印hashmap中的值
    public void printHashMap(Map<String, Integer> content) {
        Iterator it = content.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            // entry.getKey() 返回与此项对应的键
            // entry.getValue() 返回与此项对应的值
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    // 查找最热门查询
    public void findPopularQuery(Map<String, Integer> content, int k) {
        LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();// 使用ListedList来创建最大堆
        int count = 0;
        Iterator it = content.entrySet().iterator();
        while (it.hasNext() && count < k) {// 首先将hashmap中前10个元素放入ListedList当中。
            Entry entry = (Entry) it.next();
            // entry.getKey(); //返回与此项对应的键
            // entry.getValue();// 返回与此项对应的值
            // System.out.println(entry.getKey()+" "+entry.getValue());
            list.add(entry);
            count++;
        }

        //输出list中元素
        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i).getKey() + " "
                    + list.get(i).getValue());
        }

        System.out.println("----------------------");

        buildHeap(list, k);//构建最大堆，里面保存有LinkedList中的前k个元素。
        int len = content.size() - 1;//hashmap中总共的元素个数。
        while (it.hasNext()) {
            Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
            if (entry.getValue() > list.get(0).getValue()) {
                list.set(0, entry);
                adjustHeap(list, 0, k);
            }
        }

        //输出最热门查询
        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i).getKey() + " "
                    + list.get(i).getValue());
        }
    }

    //构建最小堆
    public void buildHeap(LinkedList<Entry<String, Integer>> list, int k) {
        int nonleaf = k / 2 - 1;//
        for (int i = nonleaf; i >= 0; i--) {
            adjustHeap(list, i, k);
        }
    }

    //调整最小堆
    public void adjustHeap(LinkedList<Entry<String, Integer>> list, int parent, int k) {
        int left = parent * 2 + 1;// 左节点
        while (left < k) {
            if (left + 1 < k
                    && list.get(left).getValue() > list.get(left + 1)
                    .getValue())
                left++;// 此时left代表右节点
            if (list.get(parent).getValue() <= list.get(left).getValue())//最小堆
                break;
            else {
                swap(list, parent, left);
                parent = left;
                left = parent * 2 + 1;
            }
        }
    }

    // 交换LinkedList中元素值
    public void swap(LinkedList<Entry<String, Integer>> list, int i, int j) {
        Entry temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
