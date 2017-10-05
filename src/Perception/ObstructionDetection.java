package Perception;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Random;

/**
 * Created by smrut on 9/26/2017.
 */
public class ObstructionDetection {
// send heartbeat alerts to Monitoring
public static void main(String[] args) {
    boolean alive=true;
    ProcessBuilder heartbeat=new ProcessBuilder();
    Random rn=new Random();
    int max=100;
    int min=0;

    int stateSpeedLimit=60;
    while (alive) {
        try{
        int carSpeed=rn.nextInt(max-min+1)+min;
//        BufferedReader br=new BufferedReader(new InputStreamReader());
        System.out.println(carSpeed);
        if(carSpeed>60){
            alive=false;
            System.out.println("Current Car Speed: " + carSpeed);
        }

//           Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }




    }
    System.out.println("Exceeded speed limit");


    }
}
