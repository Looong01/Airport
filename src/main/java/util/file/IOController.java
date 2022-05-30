package util.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *  Utility class {@code IOController}
 *
 *  <p>The IOController class provides some simple methods for files input or output.
 *
 *  @author  Chenyang He
 *  @version 1.0
 */
public class IOController {
    private final String filename;
    private final File file;

    /** Constructor of IOController.
     * @param filename the name of the file which needs to be I/O.
     */
    public IOController(String filename) {
        this.filename = filename;
        file = new File(filename);
    }

    private boolean checkExist() {
        return file.exists();
    }

    /** write data to the file.
     * @param data the data needed to be written
     * @return Whether it was written successfully or not
     */
    public boolean directWrite(String data) {
        OutputStream os;
        try {
            os = Files.newOutputStream(Paths.get(filename));
            PrintWriter pw = new PrintWriter(os);
            pw.print(data);
            pw.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /** read data from the file.
     * @return the data which are read from the file
     */
    public String directRead() {
        if(!checkExist()) {
            return null;
        }
        int iAvail;
        String ret=null;
        try {
            InputStream is = Files.newInputStream(Paths.get(filename));
            iAvail = is.available();
            byte[] bytes = new byte[iAvail];
            is.read(bytes);
            is.close();
            ret = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}