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
        try
        {
            while (alive) {
                //C:\Program Files\Java\jdk1.8.0_121\
                ProcessBuilder builder = new ProcessBuilder("java", "Main");
                builder.redirectErrorStream(true);

                Process heartBeat = builder.start();

                InputStream beats=heartBeat.getInputStream();

                System.out.println(beats.available());
                if(beats.available()==0){

                    alive=false;

                }
//                Reader beat = new InputStreamReader(heartBeat.getInputStream());
                BufferedReader bf = new BufferedReader(new InputStreamReader(beats));
//                System.out.println(bf);
                while ((input = bf.readLine()) != null) {
                    System.out.println(input);
                }
                bf.close();
                System.out.println("No beat");

                heartBeat.destroy();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
