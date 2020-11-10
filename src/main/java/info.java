import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class info extends ListenerAdapter {
     public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

         String[] arg1 = event.getMessage().getContentRaw().split(" ");
         String[] arg2 = event.getMessage().getContentRaw().split("\s+");


         if (arg1[0].equalsIgnoreCase(Bot1.prefix + "info")) {
             if(event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
             EmbedBuilder info = new EmbedBuilder();
             info.setTitle(":robot: Sam's Bot Information :robot:");
             info.setDescription("\n \n give truth (The bot will return a \"yes\" or \"no\" answer) \n dm me (The bot will dm you) \n hi (The bot will respond in chat with \"Hello!\") \n $pfp (the bot will show your profile picture in a bigger format) \n \n   Staff commands: \n \n $info (gives all the info about the bot) \n $delete (to delete chat history) \n $mute[user][mute role] (Mutes the user mentionned and gives them the role you mentionned) \n $ban[user] (bans the user mentionned) \n $kick[user] (kicks the user mentionned) \n \n  Note: The bot also uses a custom form of \"auto-moderation\". Any racist slurs will be detected and the user will be banned.  ");
             info.setColor(0xCC00FF);
             info.setFooter("Created by Potato", event.getMember().getUser().getAvatarUrl());

             event.getChannel().sendTyping().queue();
             event.getChannel().sendMessage(info.build()).queue();
             info.clear();
             }
         }


        }
        }
