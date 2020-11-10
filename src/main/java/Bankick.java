import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class Bankick extends ListenerAdapter {
	 public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		 String[] arg1 = event.getMessage().getContentRaw().split(" ");
		 String[] arg2 = event.getMessage().getContentRaw().split("\\s+");
		 String string = event.getMessage().getContentRaw();
		 
		
		 
		 //BAN COMMAND
		 if (arg2[0].equalsIgnoreCase(Bot1.prefix + "ban")) {
			 if(event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
				 for(Member member: event.getMessage().getMentionedMembers()) {
					 member.ban(7, string.substring(arg1[1].length()+5, string.length())).queue();
					 event.getChannel().sendMessage(arg1[1] + " was successfuly banned.").queue();
				 }
			 }
		 }
		 //KICK COMMAND
		 if (arg2[0].equalsIgnoreCase(Bot1.prefix + "kick")) {
			 if(event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
				 for(Member member: event.getMessage().getMentionedMembers()) {
					 member.kick(string.substring(arg1[1].length()+5, string.length())).queue();
					 event.getChannel().sendMessage(arg1[1] + " was successfuly kicked.").queue();
				 }
			 }
		 }
		 
		 //MUTE COMMAND
		
		 if (arg2[0].equalsIgnoreCase(Bot1.prefix + "mute")) {
			 if(event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
			Member member = event.getGuild().getMemberById(arg1[1].replace("<@", "").replace(">", "").replace("!", ""));
			 event.getGuild().addRoleToMember(member, event.getJDA().getRoleById(arg1[2].replace("<@", "").replace(">", "").replace("&", ""))).queue();
			 event.getChannel().sendMessage(arg1[1] + " was successfuly muted.").queue();
		 }
		 }
		 //UNMUTE
			 if (arg2[0].equalsIgnoreCase(Bot1.prefix + "unmute")) {
				 if(event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
				Member member = event.getGuild().getMemberById(arg1[1].replace("<@", "").replace(">", "").replace("!", ""));
				 event.getGuild().removeRoleFromMember(member, event.getJDA().getRoleById(arg1[2].replace("<@", "").replace(">", "").replace("&", ""))).queue();
				 event.getChannel().sendMessage(arg1[1] + " was successfuly unmuted.").queue();
				 }
	 }
			 }
 }
