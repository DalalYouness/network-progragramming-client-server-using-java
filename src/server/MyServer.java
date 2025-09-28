package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234 and listening on port 1234");
        Socket socket = serverSocket.accept();
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
