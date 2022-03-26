package events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserJoinEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Guild guild = event.getGuild();
        String user = event.getMember().getAsMention();

        TextChannel channels = guild.getTextChannelById("956332819200770088");

        System.out.println(user + " has joined the server.");
            channels.sendMessage("Hello, " + user + " welcome to **HistoricalMC**! Be sure to read all our rules in <#956337382649659432>!").queue();
    }
}
