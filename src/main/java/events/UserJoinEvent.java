package events;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.List;

public class UserJoinEvent extends ListenerAdapter {
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String user = event.getMember().getAsMention();
        final List<TextChannel> channels = (List<TextChannel>) event.getGuild().getTextChannelById("956332819200770088");
        assert channels != null;
        for (final TextChannel ch : channels) {
            ch.sendMessage("").queue();
        }
    }
}
