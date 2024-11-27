package edu.neu.mgen;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static HashMap<String, String> users = new HashMap<>(); // Stores usernames and passwords

    public static void main(String[] args) throws IOException {
        System.out.println("Chat server started...");
        ServerSocket serverSocket = new ServerSocket(59001);

        try {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Handle login or registration
                while (true) {
                    String action = in.readLine();
                    username = in.readLine();
                    String password = in.readLine();

                    synchronized (users) {
                        if ("REGISTER".equals(action)) {
                            if (!users.containsKey(username)) {
                                users.put(username, password);
                                out.println("REGISTRATIONSUCCESS");
                                break;
                            } else {
                                out.println("INVALID");
                            }
                        } else if ("LOGIN".equals(action)) {
                            if (users.containsKey(username) && users.get(username).equals(password)) {
                                out.println("LOGINSUCCESS");
                                break;
                            } else {
                                out.println("INVALID");
                            }
                        }
                    }
                }

                out.println("WELCOME " + username);
                System.out.println(username + " has connected.");

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    for (PrintWriter writer : clientWriters) {
                        writer.println(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                if (out != null) {
                    synchronized (clientWriters) {
                        clientWriters.remove(out);
                    }
                }
                if (username != null) {
                    System.out.println(username + " has disconnected.");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}
