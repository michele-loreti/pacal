package it.unicam.cs.pa.pacal.server;

import it.unicam.cs.pa.pacal.App;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class PaCalServer implements Runnable {

    private Logger logger = Logger.getLogger(PaCalServer.class.getName());
    public static final int DEFAULT_PORT = 9999;

    private ServerSocket serverSocket;
    private final ExecutorService executor;

    public PaCalServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.executor = Executors.newCachedThreadPool();
    }

    public PaCalServer(int port) throws IOException {
        this(new ServerSocket(port));
    }

    @Override
    public void run() {
        try {
            logger.info("Server started.");
            while (true) {
                logger.info("Waiting for a connection...");
                Socket client = serverSocket.accept();
                logger.info("Connection established ("+client.getRemoteSocketAddress().toString()+")");
                App<?> calc = App.createBasicCalculator(client.getInputStream(),client.getOutputStream());
                calc.start();
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
            e.printStackTrace();
        } finally {
            logger.info("Server closed.");
        }
    }

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if (args.length >= 1) {
            port = Integer.parseInt(args[1]);
        }
        PaCalServer server = new PaCalServer(port);
        server.run();
    }

}
