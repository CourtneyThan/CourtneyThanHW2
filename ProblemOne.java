import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.*;

class ProblemOne {
    final static int N = 10;
    static AtomicInteger count =  new AtomicInteger(0);
    static AtomicBoolean leader = new AtomicBoolean(false); 
    public static void main(String[] args) {
        // Initialize an array of N threads
        Thread[] t = new Thread[N];

        for (int i = 0; i < N; i++) {
                t[i] = new Thread(new WorkerOne());
        }

        // Let us say that the minotaur picks the guests in order
        // We can put each guest in a queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i);
        }

        // The guests decided that the first person that enters will be 
        // the leader. Keep the guests entering the maze until leader counts N
        while (count.intValue() < N) {
            int i = q.remove();
            
            // Leader
            if (i == 0) {
                leader.set(true); }
            else { // Guest
                leader.set(false); }

            try {
                t[i].run();
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace(); }

            q.add(i);
        }
        System.out.println("All of the guests entered the maze");
    }

    public static class WorkerOne extends Thread {
        boolean cake;

        public WorkerOne() {
            cake = true;
        }
        
        public void run() {
            // Check if the current thread is a leader or guest
            if (leader.get() == true) {
                count.getAndIncrement();
                System.out.println("Counter: " + count);
            }
            else {
                // Check if the guest has already eaten the cake
                if (cake == true) {
                    cake = false;
                    System.out.println("Guest ate the cake");
                }
                else {
                    System.out.println("Guest already ate the cake");
                }
            }
        }
    }
}