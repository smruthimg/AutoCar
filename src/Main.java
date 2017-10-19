import SystemManagement.Monitoring;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        ProcessBuilder builder = new ProcessBuilder("java", "SystemManagement.Monitoring");
        Process monitor = builder.start();

        BufferedReader reader = new BufferedReader( new InputStreamReader(monitor.getInputStream()));

        String ch;
        while((ch = reader.readLine())!= null) {

            System.out.println(ch);
        }
        reader.close();

        monitor.waitFor();

        System.out.println("Program complete");
    }
    }

