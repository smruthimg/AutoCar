package Perception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smrut on 9/26/2017.
 */
public class ObstructionDetection {
    Map<Integer,String> objMap=new HashMap<>();
    private void getObjects( String fileName){
        BufferedReader br=null;
        FileReader fr=null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String curr=br.readLine();
            while(curr!=null) {
                String[] obs=curr.split(",");
                if(!objMap.containsKey(Integer.parseInt(obs[0]))){
                    objMap.put(Integer.parseInt(obs[0]),obs[1]);
                    curr=br.readLine();
                }
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

// send heartbeat alerts to Monitoring
public static void main(String[] args) {


    boolean alive=true;

    ObstructionDetection od=new ObstructionDetection();
    String[] files=args[0].split(",");

    od.getObjects(files[0]);
//    od.mapInputObjects(files[1]);
    BufferedReader br=null;
    FileReader fr=null;
    try {
        fr = new FileReader(files[1]);
        br = new BufferedReader(fr);
        while(alive) {

            String curr = br.readLine();
            while (curr != null) {
                String inp = curr.trim();

                if (!od.objMap.containsKey(Integer.parseInt(inp))) {
                    alive = false;
                    System.out.println("Unable to parse sensor input");
                }
                else{
                    System.out.println(od.objMap.get(Integer.parseInt(inp))+" detected");
                }
                Thread.sleep(500);
                curr = br.readLine();

            }

        }
    }
    catch(NumberFormatException ne ){
        System.out.println("Unable to parse sensor input.The input from sensor is corrupted");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    finally{

        System.out.println("Exiting Process");
        System.exit(1);
    }


    }
}
