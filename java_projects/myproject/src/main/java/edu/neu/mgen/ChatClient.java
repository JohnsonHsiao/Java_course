package edu.neu.mgen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    private static JFrame frame;
    private static JTextArea chatArea;
    private static JTextField messageField;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatClient::createAndShowGUI);

        try {
            Socket socket = new Socket("localhost", 59001);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Handle login or registration
            while (true) {
                String[] options = {"Login", "Register"};
                int choice = JOptionPane.showOptionDialog(frame, "Choose an option:", "Login/Register",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                String username = JOptionPane.showInputDialog(frame, "Enter username:", "Login/Register", JOptionPane.PLAIN_MESSAGE);
                String password = JOptionPane.showInputDialog(frame, "Enter password:", "Login/Register", JOptionPane.PLAIN_MESSAGE);

                if (choice == 0) { // Login
                    out.println("LOGIN");
                } else { // Register
                    out.println("REGISTER");
                }

                out.println(username);
                out.println(password);

                String response = in.readLine();
                if ("LOGINSUCCESS".equals(response) || "REGISTRATIONSUCCESS".equals(response)) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials or username already exists. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Read messages from the server
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        chatArea.append(message + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField(25);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.isEmpty()) {
                out.println(message);
                messageField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(messageField);
        inputPanel.add(sendButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
