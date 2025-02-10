
package server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author 
 */
  import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Main_client {
  

     public static void main(String[] args) {
           try {
            // Connect to the server running on localhost and port 12345
            Socket socket = new Socket("localhost", 12345);  // Use the same port number as server
            System.out.println("Connected to server.");

            // Set up input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String serverMessage;
            while (true) {
                // Read message from the server
                serverMessage = in.readLine();
                System.out.println(serverMessage);

                // Send character input to the server
                String charInput = userInput.readLine();
                out.println(charInput);

                // Read message from the server
                serverMessage = in.readLine();
                System.out.println(serverMessage);

                // Send string input to the server
                String stringInput = userInput.readLine();
                out.println(stringInput);

                // Read the result from the server
                serverMessage = in.readLine();
                System.out.println(serverMessage);

                // Ask user if they want to repeat
                serverMessage = in.readLine();
                System.out.println(serverMessage);
                String repeat = userInput.readLine();
                out.println(repeat);

                if (repeat.equalsIgnoreCase("N")) {
                    break;
                }
            }

               System.out.println("Thank You!");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
