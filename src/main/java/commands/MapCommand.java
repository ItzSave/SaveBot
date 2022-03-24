package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MapCommand extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!map")) {
            event.getTextChannel().sendMessage("You can view our online map at: https://map.historicalmc.net/").queue();

        }
    }
}
