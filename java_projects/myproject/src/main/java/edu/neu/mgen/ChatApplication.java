package edu.neu.mgen;

import javax.swing.*;
import java.util.HashMap;

public class ChatApplication {
    // Adding user storage to the ChatApplication class
    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Start the login/signup GUI for client
        SwingUtilities.invokeLater(ChatClient::new);
    }
}


