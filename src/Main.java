import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
try{
    ProcessBuilder builder = new ProcessBuilder("java", "SysManagement");
    builder.redirectErrorStream(true);

    Process heartBeat = builder.start();

    InputStream beats=heartBeat.getInputStream();

    System.out.println(beats.available());
    heartBeat.destroy();

}
catch (Exception e){
    e.printStackTrace();
}
    }
}
