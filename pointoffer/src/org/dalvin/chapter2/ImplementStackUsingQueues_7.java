package org.dalvin.chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiudeyang on 19/12/16.
 */
class MyStack{
    Queue<Integer> queue = new LinkedList<Integer>();
    public void push(int x){
        queue.offer(x);
        int size = queue.size() - 1;
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    public void pop(){
        queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
         return queue.size()==0;
    }
}
public class ImplementStackUsingQueues_7 {
}
