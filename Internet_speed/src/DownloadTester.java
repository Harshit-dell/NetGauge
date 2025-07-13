import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTester {
    public static void testDownloadSpeed() {
        System.out.print("\nTesting download speed...");

        String fileUrl = "http://speedtest.tele2.net/1MB.zip";


        int bufferSize = 8192; // 8KB buffer

        try {
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);

            InputStream inputStream = conn.getInputStream();
            byte[] buffer = new byte[bufferSize];

            long totalBytesRead = 0;
            long startTime = System.nanoTime();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
            }

            long endTime = System.nanoTime();
            inputStream.close();

            double timeInSeconds = (endTime - startTime) / 1_000_000_000.0;
            double speedMbps = (totalBytesRead * 8) / (timeInSeconds * 1_000_000);

            System.out.printf("Download Speed: %.2f Mbps%n", speedMbps);

        } catch (Exception e) {
            System.out.println("Download failed: " + e.getMessage());
        }
    }
}
