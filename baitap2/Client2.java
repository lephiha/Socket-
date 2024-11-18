package baitap2;

import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to the server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;
            while (true) {
                // Gửi tin nhắn từ Client
                System.out.print("Client: ");
                clientMessage = keyboard.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client is disconnecting...");
                    break;
                }

                // Nhận tin nhắn từ Server
                serverMessage = in.readLine();
                if (serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server has disconnected.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
