package org.example;



public class Main {
    public static void main(String[] args) {
        TwitterBot twitterBot = new TwitterBot("MTE2NDAyMTAyOTMxNjg1Mzg5NA.GjipMM.Op_ViO6yVC8llZVEGMZIbh-KUjfKznMDq5YUQ8");
        Runtime.getRuntime().addShutdownHook(new Thread(twitterBot::onShutdown));

        try {
            twitterBot.start();
        } catch (Exception e) {
            System.err.println("Error starting Twitterbot: " + e.getMessage());
        }
    }
}

