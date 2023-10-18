package org.example;



public class Main {
    public static void main(String[] args) {
        TwitterBot twitterBot = new "YOUR_TOKEN_HERE");
        Runtime.getRuntime().addShutdownHook(new Thread(twitterBot::onShutdown));

        try {
            twitterBot.start();
        } catch (Exception e) {
            System.err.println("Error starting Twitterbot: " + e.getMessage());
        }
    }
}

