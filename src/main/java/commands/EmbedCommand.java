package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class EmbedCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;
        }

        if (event.isFromType(ChannelType.PRIVATE)) {
            return;
        }


        if (event.getMessage().getContentRaw().equals("!embed")) {

            MessageChannel channel = event.getChannel();


            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(0xFF00FF);
            eb.setTitle("This is a title");
            eb.setTimestamp(Instant.now());


            MessageBuilder message = new MessageBuilder();

            message.setEmbeds(eb.build());

            channel.sendMessage(message.build()).queue();
        }
    }
}
