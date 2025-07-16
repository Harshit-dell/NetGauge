# NetGauge

NetGauge is a Java-based internet speed testing tool featuring client and server components. It measures download speed, upload speed, and ping (latency) using a custom-built HTTP server and native system commands. The entire tool is implemented using core Java with no external libraries.

## Features

- Download speed test over HTTP
- Upload speed test using streamed data
- Ping test using the system's native `ping` command
- Custom lightweight HTTP server
- Nanosecond-level timing for accurate Mbps calculation
- Plain, dependency-free Java code
## Components

### Server (`server/`)

  - `Custom_server`: A basic HTTP server using `ServerSocket`, handling:
  - `GET /download`: Streams binary data to test download speed
  - `POST /upload`: Accepts binary data to test upload speed

### Client (`client/`)

- `DownloadHandler.java`: Downloads a fixed-size payload from the server and calculates download speed
- `UploadHandler.java`: Uploads a fixed-size payload to the server and calculates upload speed
- `PingTester.java`: Runs the system's `ping` command (e.g., `ping -c 4 google.com`) using `ProcessBuilder`, capturing real ICMP ping results


Before running any test, you **must start the custom HTTP server** included in this repository.  
The server handles both `/download` and `/upload` requests and must be active for the client tests to function properly.
