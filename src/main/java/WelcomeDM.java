import java.nio.channels.Channel;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class WelcomeDM extends ListenerAdapter {
     public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

         String[] arg1 = event.getMessage().getContentRaw().split(" ");
         String[] arg2 = event.getMessage().getContentRaw().split("\s+");

         if (event.getMessage().getContentRaw().equalsIgnoreCase("dm me")) {
        Member member = event.getMember();
        member.getUser().openPrivateChannel().queue(channel ->{
            channel.sendMessage("Hi!").queue();
        });


         }
         }


        }
