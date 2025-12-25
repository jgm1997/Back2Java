package es.jgm1997.sprint1.virtualthreads;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class VirtualThreadServer {
    static Logger logger = Logger.getLogger(VirtualThreadServer.class.getName());

    private VirtualThreadServer() {
        throw new AssertionError("Utility class");
    }

    public static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/hello", exchange -> {
            String response = "Hello from virtual threads!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        server.start();
        logger.info("Server started on http://localhost:8080/hello");
    }
}
