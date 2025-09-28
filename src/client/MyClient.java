package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static int readNumberFromClient() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a positive number: ");
            number = scanner.nextInt();
        }while (number  < 0);
        return number;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("i will connect to server");
        Socket socket = new Socket("localhost",1234);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        int input = readNumberFromClient();
        out.write(input);
        System.out.println("i will wait for the server response");
        int response = in.read();
        System.out.println("server response is " + response);
        socket.close();


    }
}
