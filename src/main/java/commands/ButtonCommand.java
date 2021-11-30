package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

import java.time.Instant;

public class ButtonCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals("!createrolereact")) {

            if (!event.getAuthor().getName().equals("Test")){
                System.out.println("A user tried to run this command that does not have permission!");
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(0xFF0000);
                eb.setTitle("No Permission!");
                eb.setDescription("You do not have permission to use this command!");
                eb.setTimestamp(Instant.now());
                MessageBuilder message = new MessageBuilder();
                message.setEmbeds(eb.build());

                MessageChannel channel = event.getChannel();
                channel.sendMessage(message.build()).queue();


                return;
            }

            System.out.println("Hello command has been run.");

            MessageChannel channel = event.getChannel();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(0xFF00FF);
            eb.setTitle("This is a title");
            eb.setTimestamp(Instant.now());

            MessageBuilder message = new MessageBuilder();

            message.setEmbeds(eb.build());

            TextChannel textChannel = event.getGuild().getTextChannelsByName("ideas", true).get(0);
            textChannel.sendMessage(message.build())
                    .setActionRow((Button.primary("hello", "Click Me"))).queue(); // Button with only a label

        } else {
            return;
        }
    }

    public void onButtonClick(ButtonClickEvent event) {
        if (event.getComponentId().equals("hello")) {
            event.reply("Hello :)").queue();
            Role role = event.getGuild().getRolesByName("Notifications", false).get(0);


            event.getGuild().addRoleToMember(event.getMember(), role).queue();


        }
    }
}
