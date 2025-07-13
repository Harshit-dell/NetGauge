import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingTester{
    public static void pingGoogle() {
        try {
            ProcessBuilder builder = new ProcessBuilder("ping", "-c", "4", "google.com");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = buffer.readLine()) != null) {
                    System.out.println(line);
                }
            }
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Ping failed: " + e.getMessage());
        }
    }
}