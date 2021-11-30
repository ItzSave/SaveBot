import commands.BotCommand;
import commands.EmbedCommand;
import commands.PingCommand;
import events.BotReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class SaveBot {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("NTQ1NjUwNjA1NTc0NTg2MzY4.XGWeug.082qEmtDbPK1HuHDoKhVdBPqkTI")
                .addEventListeners(new PingCommand())
                .addEventListeners(new EmbedCommand())
                .addEventListeners(new BotReadyEvent())
                .addEventListeners(new BotCommand())
                .setActivity(Activity.listening("Now running on JDA"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

        jda.awaitReady();
        System.out.println("JDA successfully loaded!");
    }


}
