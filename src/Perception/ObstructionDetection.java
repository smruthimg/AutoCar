package Perception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    final static String filePath = "Data/SensorInput.txt";
    static BufferedReader reader;
    public static void main(String[] args) throws InterruptedException, IOException {

        reader = new BufferedReader(new FileReader(filePath));
        if(args.length > 0 && args[0].equals("original")) {
            readInputusingAlgo1();
        } else {
            readInputusingAlgo2();
        }
    }

    private static void readInputusingAlgo1() throws IOException, InterruptedException {

        String line = null;
        while((line = reader.readLine()) != null) {
            System.out.println(Integer.parseInt(line));
            Thread.sleep(2000);
        }
    }

    private static void readInputusingAlgo2() throws NumberFormatException, IOException, InterruptedException {

        String line = null;

        while((line = reader.readLine()) != null) {
            System.out.println(Double.parseDouble(line));
            Thread.sleep(2000);
        }
    }
}
