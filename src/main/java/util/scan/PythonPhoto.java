package util.scan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PythonPhoto {
    public void takePhoto(String userId){
        try {
            Process proc;
            proc = Runtime.getRuntime().exec("python3 /Users/gody/Desktop/Airport/src/main/java/util/scan/photo.py "+userId);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String userId="3442";
//
//        try {
//            Process proc;
//            proc = Runtime.getRuntime().exec("python3 /Users/gody/Desktop/Airport/src/main/java/util/scan/photo.py "+userId);
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            String line = null;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            proc.waitFor();
//        }catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}




