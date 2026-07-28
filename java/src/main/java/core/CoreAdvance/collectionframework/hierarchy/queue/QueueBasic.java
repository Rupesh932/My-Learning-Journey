package core.CoreAdvance.collectionframework.hierarchy.queue;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueBasic {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        //single ended queue

        //enqueue
        queue.add((22));//exception if fail
        queue.offer((10));// false if fail
        queue.offer(55);
        System.out.println(queue);

        //front access
        System.out.println(queue.peek());//null, if front absence
        System.out.println(queue.element());//exception if front absence

        //remove
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
