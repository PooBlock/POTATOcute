import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Delete extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

         String[] arg1 = event.getMessage().getContentRaw().split(" ");
         String[] arg2 = event.getMessage().getContentRaw().split("\s+");

         if(event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
         if (arg2[0].equalsIgnoreCase(Bot1.prefix + "delete")) {

             if (Integer.parseInt(arg2[1]) > 100){
               EmbedBuilder error = new EmbedBuilder();
               error.setColor(0xff3923);
               error.setTitle(":o: Too many or not enough messages selected :o:");
               error.setDescription("- Enter between 2-100 -");
               event.getChannel().sendMessage(error.build()).queue();

             }else if(Integer.parseInt(arg2[1]) < 2) {
                 EmbedBuilder error = new EmbedBuilder();
                   error.setColor(0xff3923);
                   error.setTitle(":o: Too many or not enough messages selected :o:");
                   error.setDescription("- Enter between 2-100");
                   event.getChannel().sendMessage(error.build()).queue();

                }else{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(arg1[1])).complete();
                 event.getChannel().deleteMessages(messages).queue();
                }
           }
    }

}
}
