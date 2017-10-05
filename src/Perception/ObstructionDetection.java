package Perception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/**
 * The representation of an obstruction detection component. the class is responsible
 * for reading the input from sensors and identify the objects in the surrounding
 * Author: Smruthi Gadenkanahalli
 * Creation Date: 9/26/2017.
 */
public class ObstructionDetection {
    Map<Integer,String> objMap=new HashMap<>();
    // Scenario: Read the file with identified objects and create a dictionary wth id and name of objects

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

//Scenario: Read the input from file SensorInput which is received from Sensors .
    //The entries are int.
    //Failure scenario: the input for one of the obstructions identified by the sensors is corrupted
    // and the format is not int.
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
//CHeck if the entry is present in the Map.
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
        System.exit(1);
    }
    catch(Exception e){
        e.printStackTrace();
    }



    }
}
