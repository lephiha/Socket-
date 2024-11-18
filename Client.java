import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Input two integers from the user
            System.out.print("Enter the first integer (a): ");
            int a = scanner.nextInt();
            System.out.print("Enter the second integer (b): ");
            int b = scanner.nextInt();

            // Send the numbers to the server
            out.println(a);
            out.println(b);

            // Receive the result from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
