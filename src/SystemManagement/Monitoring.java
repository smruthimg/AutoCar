package SystemManagement;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by smrut on 10/4/2017.
 */
public class Monitoring extends Process {


    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public InputStream getErrorStream() {
        return null;
    }

    @Override
    public int waitFor() throws InterruptedException {
        return 0;
    }

    @Override
    public int exitValue() {
        return 0;
    }

    @Override
    public void destroy() {

    }


}
