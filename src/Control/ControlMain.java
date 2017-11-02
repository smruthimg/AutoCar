package Control;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by smrut on 11/1/2017.
 */
public class ControlMain {
    public static void main(String[] args) {
        Random rand=new Random();
        int max=1000;
        int min=100;
        ExecutorService exec= Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            Thread t=new Processor((rand.nextInt(max-min)+min),i);
            if(i%2==0) {
                t.setPriority(1);
            }

            exec.execute(t);
        }
        exec.shutdown();
        while(!exec.isTerminated()){
// dont close yet, the threads are running

        }
        System.out.println("Processed all the threads");
    }
}
