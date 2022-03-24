import commands.ButtonCommand;
import commands.EmbedCommand;
import discord.events.BotReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class SaveBot extends ListenerAdapter {


    public static void main(String[] args) throws LoginException, InterruptedException {

        JDA jda = JDABuilder.createDefault("OTQ1MDQ4NjAxOTkyNzU3MzU5.YhKfGA.MfCge4MH574xzAg28B42rFjzjIY")
                .addEventListeners(new EmbedCommand())
                .addEventListeners(new BotReadyEvent())
                .addEventListeners(new ButtonCommand())
                .setActivity(Activity.playing("on play.historicalmc.net"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

        jda.awaitReady();
        System.out.println("Bot has started");
    }


}
