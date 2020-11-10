import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.HashMap;
 public class reactionrole extends ListenerAdapter {

	  final long channelID = 770101111150870539L;
      final long roleID = 770100157068345344L;
  final long messageID = 774063216439459911L;
 
        long mmember = 770100157068345344L;
  
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        	
        	String string = event.getMessage().getContentRaw();
        	String[] arg1 = event.getMessage().getContentRaw().split(" ");
        	
        	
        	
        	/*if(arg1[0].toLowerCase().equals("potato")) {
        Member notmember = event.getMember();
        event.getGuild().addRoleToMember(notmember, event.getJDA().getRoleById(mmember)).queue();
        event.getChannel().sendMessage("Type \"potato\" to verify:").queue();
        
        	}*/
        	  
    }
        public void onMessageReactionAdd(MessageReactionAddEvent event) {


            if (event.getChannel().getIdLong() == channelID) {
                if (event.getMessageIdLong() == messageID) {
                    Member reacte = event.getMember();
                    event.getGuild().addRoleToMember(reacte, event.getJDA().getRoleById(roleID)).queue();

                }
            }
        }
 }