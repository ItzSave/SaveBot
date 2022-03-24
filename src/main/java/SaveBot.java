import commands.MapCommand;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import commands.ButtonCommand;
import events.UserJoinEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveBot extends ListenerAdapter {

    public static void main(String[] args) {

        try {

            Reader reader = Files.newBufferedReader(Paths.get("token.json"));

            Object ob = new JSONParser().parse(reader);

            JSONObject js = (JSONObject) ob;

            String token = (String) js.get("token");

            JDA jda = JDABuilder.createDefault(token)
                    .addEventListeners(new ButtonCommand())
                    .addEventListeners(new UserJoinEvent())
                    .addEventListeners(new MapCommand())
                    .setActivity(Activity.playing("on play.historicalmc.net"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .build();

            jda.awaitReady();
            System.out.println("Bot has started");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
