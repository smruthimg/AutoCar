package SystemManagement;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by smrut on 10/4/2017.
 */
public class Monitoring  {
    public static void main(String[] args) {
        String input;
        Boolean alive=true;
        String classname=SysManagement.class.getName();
//        System.out.println(classname);
        try
        {
            while (alive) {

//                Runtime rn=Runtime.getRuntime();
               ProcessBuilder builder = new ProcessBuilder("java", "-cp","C:\\Users\\smrut\\OneDrive\\Documents\\755-Arch\\AutoCar\\AutoCar\\out\\production\\755-Arch","Perception.ObstructionDetection",args[0]);
              builder.redirectErrorStream(true);
//
                Process heartBeat = builder.start();

                InputStream beats=heartBeat.getInputStream();
//                InputStream stderr=heartBeat.getErrorStream();
//
//
                if(beats.available()==0){

                    alive=false;

                }
                BufferedReader bf = new BufferedReader(new InputStreamReader(beats));
                while ((input = bf.readLine()) != null) {
                    System.out.println(input);
                }
                bf.close();
                System.out.println("No Heartbeat. ");

                heartBeat.destroy();


            }
        }
        catch (Exception ex){
//            ex.printStackTrace();
            System.out.println("The monitoring process has failed");
        }
    }



}
