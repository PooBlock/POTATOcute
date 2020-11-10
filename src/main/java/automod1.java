import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class automod1 extends ListenerAdapter {
	 public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		 String[] arg1 = event.getMessage().getContentRaw().split(" ");
		 String string = event.getMessage().getContentRaw();
		 
		 
		 if (string.toLowerCase().contains("nigger")||string.toLowerCase().contains("nigga")||string.toLowerCase().contains("niger")) {
	 
			event.getChannel().sendMessage("**Hello "+event.getMember().getAsMention()+", congrats on the ban! \nYou have 10 seconds left :)**").queue();
			 
			
					Member member = event.getMember();
					member.getUser().openPrivateChannel().queue(channel ->{
						channel.sendMessage("You will be banned in: \n10").queue();
					});
					
					int a;
					a=20;
					int[] countdown = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
					while (a>0) {
					   a--;
					   String s = String.valueOf(a);
					   final int i =  a;

					   member.getUser().openPrivateChannel().queue(channel -> {
					        channel.sendMessage(s).queueAfter(countdown[i], TimeUnit.SECONDS);
					   });
					}

					
		    event.getMember().ban(7).queue();
		    
				 
				 }
		 while(true) {
			 if(event.getChannel().toString().toLowerCase().contains("self")&&event.getChannel().toString().toLowerCase().contains("promo")) {
				 break;
				 
			 }else {
		 
		 if(string.toLowerCase().contains("where") && string.toLowerCase().contains("self") && string.toLowerCase().contains("promo")
                 ||string.toLowerCase().contains("server") && string.toLowerCase().contains("my")&&string.toLowerCase().contains("join")||string.toLowerCase().contains("sub")&&string.toLowerCase().contains("my")&&string.toLowerCase().contains("channel")) {
            String c;
             if(event.getGuild().getChannels().toString().toLowerCase().contains("self-promo")||event.getGuild().getChannels().toString().toLowerCase().contains("self")&&event.getGuild().getChannels().toString().contains("promo")) {

                 String k;
                 k= "(This server does not have a \"self-promo\" channel)";
             List<TextChannel> a = event.getGuild().getTextChannels();

             int p = 0;
             while (true) {

             if(a.get(p).toString().contains("self-promo")||a.get(p).toString().contains("self")&& a.get(p).toString().contains("promo")){
                 k = a.get(p).toString();
                 break;
             }else {
                 p++;
                 continue;
        }
    }

         event.getChannel().sendMessage("**"+event.getMember().getAsMention() + " use <#"+ k.replaceAll("[^0-9]", "") +"> to promote**").queue();
             }
            }
		 
		break;
			 }
			 }
		 
		 
			 if(event.getChannel().toString().toLowerCase().contains("self")&&event.getChannel().toString().toLowerCase().contains("promo")) {
				 
			 }else {
	if(string.toString().toLowerCase().contains("discord.gg")|| string.toString().toLowerCase().contains("https://www.youtube.com")) {
		
          List<Message> messages = event.getChannel().getHistory().retrievePast(2).complete();
       event.getChannel().deleteMessages(messages).queue();
	}
	
	  }
      }
	 }
