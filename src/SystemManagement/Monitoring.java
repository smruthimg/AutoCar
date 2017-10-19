package SystemManagement;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * The representation of an Monitoring component. the class is responsible
 * for reading the heartbeat signals from Obstruction detection component
 * and notify if the component has failed
 * Author: Smruthi Gadenkanahalli,Pratham Mehta,Umang Garg
 * Creation Date: 9/26/2017.
 */
public class Monitoring  {
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
//        System.out.println("inside monitoring");
        ProcessBuilder builder = new ProcessBuilder("java","Perception.ObstructionDetection", "original");
        builder.redirectErrorStream(true);
        Process obsDet = builder.start();

        ProcessBuilder builder2 = new ProcessBuilder("java","Perception.ObstructionDetection", "2");
        builder2.redirectErrorStream(true);
        Process obsDet2 = builder2.start();

        detectHeartBeat(obsDet, obsDet2);

        obsDet.waitFor();
        obsDet2.waitFor();
    }

    static void detectHeartBeat(Process p, Process p1) throws InterruptedException, IOException {
        int isAliveCount = 0;
        String line = null;
        try {
            if(p.isAlive()) {
                if( p.getInputStream().available() > 0) {
                    line = new BufferedReader(new InputStreamReader(p.getInputStream())).readLine();

                    System.out.println("reading from original");
                    System.out.println(line);
                }
                isAliveCount++;
            } else {
                System.out.println("redundant is now active");
            }
        } catch (Exception e) {
            p.destroyForcibly();
            isAliveCount--;
        }

        try {
            if(p1.isAlive()) {
                if( p1.getInputStream().available() > 0) {
                    line = new BufferedReader(new InputStreamReader(p1.getInputStream())).readLine();
                    if(p.isAlive()) {
                        System.out.println("redundant is alive");
                    } else {
                        System.out.println(line);
                    }
                }
                isAliveCount++;
            }
        } catch (Exception e) {
            System.out.println("p1 dead");
            p1.destroyForcibly();
            isAliveCount--;
        }
        if(isAliveCount > 0) {
            Thread.sleep(1000);
            detectHeartBeat(p, p1);
        }
    }


}
