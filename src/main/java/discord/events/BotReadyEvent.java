package discord.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotReadyEvent extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event){

        int servers = event.getGuildTotalCount();

        System.out.println("Bot is ready to go! Listening to " + servers + " guilds");

    }
}
