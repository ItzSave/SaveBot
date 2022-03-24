package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

import java.time.Instant;
import java.util.Objects;

public class ButtonCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals("!createrolereact")) {

            if (!event.getAuthor().getId().equals("111984776272949248")) {
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

            System.out.println("Role React Message has been added.");


            MessageChannel channel = event.getChannel();

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(0xfcba03);
            eb.setTitle("Notifications Roles");
            eb.setDescription("Click on the buttons below to add or remove roles.");
            eb.setFooter(event.getJDA().getSelfUser().getName());
            eb.setTimestamp(Instant.now());

            MessageBuilder message = new MessageBuilder();

            message.setEmbeds(eb.build());

            TextChannel textChannel = event.getGuild().getTextChannelById("956337119377387540");
            assert textChannel != null;
            textChannel.sendMessage(message.build())
                    .setActionRow((Button.success("Updates", "Updates")),
                            (Button.success("Giveaways", "Giveaways")),
                            (Button.success("Polls", "Polls")))

                    .queue(); // Button with only a label

        } else {
            return;
        }
        event.getMessage().delete().queue();
    }

    public void onButtonClick(ButtonClickEvent event) {
        //Checking for when a user clicks on the alerts button.
        if (event.getComponentId().equals("Updates")) {

            Role role = Objects.requireNonNull(event.getGuild()).getRolesByName("Updates", true).get(0);

            event.deferReply().queue();

            if (Objects.requireNonNull(event.getMember()).getRoles().contains(role)) {
                event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), role).queue();
            }
            event.getHook().deleteOriginal().queue();
        }

        //Checking for when a user clicks on the giveaway button.
        if (event.getComponentId().equals("Giveaways")) {

            Role role = Objects.requireNonNull(event.getGuild()).getRolesByName("Giveaways", false).get(0);

            event.deferReply().queue();

            if (Objects.requireNonNull(event.getMember()).getRoles().contains(role)) {
                event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), role).queue();
            }
            event.getHook().deleteOriginal().queue();
        }

        //Added poll role to the user
        if (event.getComponentId().equals("Polls")) {

            Role role = Objects.requireNonNull(event.getGuild()).getRolesByName("Polls", false).get(0);

            event.deferReply().queue();

            if (Objects.requireNonNull(event.getMember()).getRoles().contains(role)) {
                event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            } else {
                event.getGuild().addRoleToMember(event.getMember(), role).queue();
            }
            event.getHook().deleteOriginal().queue();
        }
    }
}
