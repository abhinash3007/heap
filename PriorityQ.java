package HEAP;
import java.util.*;;
public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer>p=new PriorityQueue<>();
        p.add(1);
        p.add(5);
        p.add(7);
        p.add(2);
        p.add(6);
        while (!p.isEmpty()) {
            System.out.println(p.peek());
            p.remove();
        }

    }    
}
