import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SpeedTestApp {
    public static void main(String[] args) {
        System.out.println("Starting Intenet SPeed TEst.....");
        pingGoogle();
    }

    public static void pingGoogle() {
       try{
           ProcessBuilder builder=new ProcessBuilder("ping","-c","4","google.com");
           builder.redirectErrorStream(true);
           Process process= builder.start();
           BufferedReader buffer=new BufferedReader(new InputStreamReader(process.getInputStream()));
           String line;
           while(((line=buffer.readLine()) !=null )){
               System.out.println(line);
           }
           buffer.close();
           process.waitFor();
       }
       catch (Exception e){
           System.out.println("ping failed "+e.getMessage());
       }
    }
}