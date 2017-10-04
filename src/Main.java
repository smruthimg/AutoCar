import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



	    ProcessBuilder pb=new ProcessBuilder();
	    pb.command();// cmd to execute on start of process
	    try{
	        pb.start();

        }
        catch (IOException e){
	        e.printStackTrace();

        }


    }
}
