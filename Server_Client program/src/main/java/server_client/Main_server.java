
package server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 import java.io.*;
import java.net.*;

/**
 *
 * @author 
 */
public class Main_server {
   


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // Create a ServerSocket to listen for connections
            ServerSocket serverSocket = new ServerSocket(12345);  // Valid port number
            System.out.println("Server is running... Waiting for a client to connect.");

            // Wait for client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Set up input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String repeat = "Y";
            while (repeat.equalsIgnoreCase("Y")) {
                // Get the character to search for
                out.println("Enter a Character to be searched: ");
                String charInput = in.readLine();
                if (charInput == null || charInput.isEmpty()) {
                    out.println("Invalid input. Please enter a valid character.");
                    continue;
                }
                char character = charInput.charAt(0); // Assuming user enters a valid character

                // Get the string to search in
                out.println("Enter a String: ");
                String inputString = in.readLine();
                if (inputString == null || inputString.isEmpty()) {
                    out.println("Invalid input. Please enter a valid string.");
                    continue;
                }

                // Convert both character and string to lowercase for case-insensitive comparison
                char searchChar = Character.toLowerCase(character);
                String lowerCaseString = inputString.toLowerCase();

                // Count occurrences of the character in the string
                int count = 0;
                for (int i = 0; i < lowerCaseString.length(); i++) {
                    if (lowerCaseString.charAt(i) == searchChar) {
                        count++;
                    }
                }

                // Send the result back to the client
                out.println("The number of Occurrences are: " + count);

                // Ask if the user wants to repeat
                out.println("Want to repeat (Y/N): ");
                repeat = in.readLine();
            }
System.out.println("Disconnected from server.");
            out.println("Thank You!");
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
