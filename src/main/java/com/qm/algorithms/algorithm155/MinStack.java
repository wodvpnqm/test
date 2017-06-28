package com.qm.algorithms.algorithm155;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by wodvpn on 2017/3/19.
 */
public class MinStack {

    private List<Integer> stack;
    private PriorityQueue<Integer> pq;

    public MinStack()
    {
        stack = new ArrayList<>();
    }


    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size()-1);

    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return new PriorityQueue<>(stack).poll();
    }
}
