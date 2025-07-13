import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeedTestApp {
    public static void main(String[] args) {
        System.out.print("Starting Intenet Speed Test.....");
        PingTester.pingGoogle();
        Thread t = new Thread(() -> {
            try {
               while(!Thread.currentThread().isInterrupted()){
                   Thread.sleep(500);
                   System.out.print(".");
               }
            }
            catch (Exception e){}

        });
        t.start();

        DownloadTester.testDownloadSpeed();
        t.interrupt();
    }
}