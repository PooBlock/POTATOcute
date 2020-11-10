import java.nio.channels.Channel;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class EmbedMaker extends ListenerAdapter {
     public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

         String[] arg1 = event.getMessage().getContentRaw().split(" ");
         String[] arg2 = event.getMessage().getContentRaw().split("\s+");
         String string = event.getMessage().getContentRaw();

         if (arg1[0].toString().equals("$embed")) {
        	 if(event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
        	 
  EmbedBuilder embed = new EmbedBuilder();
  embed.setDescription(string.replace("$embed", ""));
  embed.setColor(0xCC00FF);
  event.getChannel().sendMessage(embed.build()).queue();
         
        	 }
         }
         }


        }