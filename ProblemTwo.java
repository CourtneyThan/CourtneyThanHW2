import java.util.*;
import java.lang.*;
import java.util.concurrent.*;

class ProblemTwo {
    final static int N = 10;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        // Initialize an array of N threads
        Thread[] t = new Thread[N];

        for (int i = 0; i < N; i++) {
            t[i] = new Thread(new WorkerTwo(i)); }

        // Let us say that the guest enter the line in order
        // We can put each guest in a queue
        for (int i = 0; i < N; i++) { 
            q.add(i); }

        while (!q.isEmpty()) {
            int i = q.remove();

            try {
                t[i].run();
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All of the guests entered the vase room");

    }

    
    public static class WorkerTwo extends Thread {
        int index;
        public WorkerTwo(int index) {
            this.index = index;
        }
        
        public void run() {
            System.out.println("Guest #" + index + " has entered the room");

            System.out.println("Guest #" + index + " has left the room");

            // 50% chance guest re-enters the queue
            if (Math.random() < 0.5) {
                q.add(index);
                System.out.println("Guest #" + index + " has re-entered the line");
            }
        }
    }
}
