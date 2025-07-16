import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class UploadTester {
    public static String fileurl = "http://localhost:8080/upload";

    public static void uploadTest() {
        System.out.println("Starting upload-speed test...");

        try {
            URL url = new URL(fileurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int dataSize = 10 * 1024 * 1024; // 10 MB
            byte[] sendBuffer = new byte[1024]; // 1 KB buffer
            new Random().nextBytes(sendBuffer); // Fill buffer with random data

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.setFixedLengthStreamingMode(dataSize);
            connection.connect();

            OutputStream output = connection.getOutputStream();

            double startTime = System.nanoTime();
            int sent = 0;
            while (sent < dataSize) {
                output.write(sendBuffer);
                sent += sendBuffer.length;
            }

            InputStream in = connection.getInputStream();
            while (in.read() != -1) {

            }
            double endTime = System.nanoTime();

            double timeTakenSec = (endTime - startTime) / 1_000_000_000.0;
            double speedMbps = (dataSize * 8) / (timeTakenSec * 1_000_000);

            System.out.printf("Upload completed in %.2f seconds\n", timeTakenSec);
            System.out.printf("Upload speed: %.2f Mbps\n", speedMbps);

        } catch (Exception e) {
            System.out.println("Upload failed: " + e.getMessage());
        }
    }
}
