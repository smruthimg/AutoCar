package SystemManagement;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * The representation of an Monitoring component. the class is responsible
 * for reading the heartbeat signals from Obstruction detection component
 * and notify if the component has failed
 * Author: Smruthi Gadenkanahalli
 * Creation Date: 9/26/2017.
 */
public class Monitoring  {
    public static void main(String[] args) {
        String input;
        Boolean alive=true;
        String classname=SysManagement.class.getName();

        try
        {
            while (alive) {

//                Runtime rn=Runtime.getRuntime()
// Creating a process to execute the Obstruction detection class
               ProcessBuilder builder = new ProcessBuilder("java", "-cp",".\\out\\production\\755-Arch","Perception.ObstructionDetection",args[0]);
              builder.redirectErrorStream(true);
//
                Process heartBeat = builder.start();

                InputStream beats=heartBeat.getInputStream();
//                InputStream stderr=heartBeat.getErrorStream();

//Check if the heartbeat is being received.
                if(beats.available()==0){

                    alive=false;

                }
                BufferedReader bf = new BufferedReader(new InputStreamReader(beats));

                while ((input = bf.readLine()) != null) {
                    System.out.println(input);
                }
                bf.close();
                System.out.println("No heartbeat received.The critical component has failed! ");
// no heartbeat. bring out your dragon glass
                heartBeat.destroy();
                System.out.println("Restart Process?y/n");
                Scanner scan=new Scanner(System.in);
                if(scan.nextLine().equals("y")){
                    alive=true;
                }


            }
        }
        catch (Exception ex){

            //The Monitoring process has failed #Bendtheknee
//            ex.printStackTrace();
            System.out.println("The monitoring process has failed. Switching to manual mode");
        }
    }



}
