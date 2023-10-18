package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterBot extends ListenerAdapter {
    private Message message;
    private JDA jda;
    private String DISCORD_BOT_TOKEN;

    public TwitterBot(String DISCORD_BOT_TOKEN) {
        this.DISCORD_BOT_TOKEN = DISCORD_BOT_TOKEN;

    }
    public void start() throws Exception {
        jda = JDABuilder.createLight(DISCORD_BOT_TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).addEventListeners(this).build();
    }

    public void onShutdown() {
        System.out.println("shutting down...");
        jda.shutdown();
    }

    @Override
    public void onReady(ReadyEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event was null");
        }
        System.out.println("Logged in as " + event.getJDA().getSelfUser());
        System.out.println("Twitterbot has come online");

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        String regex = "https://twitter\\.com(/\\S*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);

        String regex2 = "https://x\\.com(/\\S*)?";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(message);

        if (matcher.find()) {
            String replacedMessage = message.replaceFirst("https://twitter.com", "https://vxtwitter.com");
            event.getChannel().sendMessage(replacedMessage).queue();
        }
        if (matcher2.find()) {
            String replacedMessage = message.replaceFirst("https://x.com", "https://vxtwitter.com");
            event.getChannel().sendMessage(replacedMessage).queue();
        }
    }
}

