import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
    public MyStack() {
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();    
    }
   
    public void push(int x) {
       this.queue1.add(x);
    }
    
    private void q1toq2() {
        while(!this.queue1.isEmpty()) {
     	   this.queue2.add(this.queue1.remove());
        }
    }
    private void q2toq1() {
    	while(!this.queue2.isEmpty()) {
     	   this.queue1.add(this.queue2.remove());
        }
    }
    
    public int pop() {
       q1toq2();
       int returny = this.queue2.remove();
       q2toq1();
       return returny;
    }
   
    public int peek() { 
        q1toq2();
        int returny = this.queue2.peek();
        q2toq1();
        return returny;
    }
   
    public boolean empty() {
       return this.queue1.isEmpty();
    }
}	