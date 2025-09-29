package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("waiting connection...");
        Socket socket = serverSocket.accept();
        System.out.println("client connected to: " + socket.getRemoteSocketAddress());
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("Client connected to server , waiting data from client");
        int nbr = inputStream.read();
        System.out.println("server received: " + nbr);
        int res = nbr + 10;
        System.out.println("server sent: " + res);
        outputStream.write(res);
        socket.close();

    }


}
