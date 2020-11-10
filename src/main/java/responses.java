import java.util.Random;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

 public class responses extends ListenerAdapter {


        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {


         String[] arg1 = event.getMessage().getContentRaw().split(" ");
         String[] arg2 = event.getMessage().getContentRaw().split("\s+");
         String string = event.getMessage().getContentRaw();


        //RESPONSE 1
         if (arg1[0].equalsIgnoreCase("hi")) {
             event.getChannel().sendMessage("Hello!").queue();
             }


         //RESPONSE 2
         String answers[] = {"yes", "no"};

            if (arg1[0].equalsIgnoreCase(Bot1.prefix1) && arg1[1].equals("truth")) {
                event.getChannel().sendMessage(answers[new Random().nextInt(answers.length)]).queue();
            }


            //RESPONSE 3
        if(string.toLowerCase().contains("when") && string.contains("exam")||string.contains("date") && string.contains("exam")) {
            event.getChannel().sendMessage("type \"$\" following with your group (ex: Group0) to view upcoming scheduled exams").queue();

        }
        if(arg1[0].equalsIgnoreCase(Bot1.prefix + "group12")) {
            EmbedBuilder info = new EmbedBuilder();
             info.setTitle("Group 12 TimeTable:");
             info.setImage("https://media.discordapp.net/attachments/664941342895636520/770383670941843516/obama.PNG%22");
             event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
        
        if(arg1[0].equals("$pfp")) {
			 
			 Member member = event.getMember();
		        EmbedBuilder yeet = new EmbedBuilder();
		        yeet.setImage(member.getUser().getAvatarUrl());
		        event.getChannel().sendMessage(yeet.build()).queue();
		        
		        
		        }
        String abc[] = {"idk", "not sure tbh"};
        if((string.toLowerCase().startsWith("is")||string.toLowerCase().startsWith("should")||string.toLowerCase().startsWith("am")||string.toLowerCase().startsWith("did")||string.toLowerCase().startsWith("are")||string.toLowerCase().startsWith("can")||string.toLowerCase().startsWith("do")||string.toLowerCase().startsWith("does"))&&(string.endsWith("?")||string.endsWith(""))) {
            event.getChannel().sendMessage(answers[new Random().nextInt(answers.length)]).queue();
        }else if((string.toLowerCase().startsWith("why")||string.toLowerCase().startsWith("how")||string.toLowerCase().startsWith("when")||string.toLowerCase().startsWith("who")||string.toLowerCase().startsWith("what"))&&(string.endsWith("?")||string.endsWith(""))) {
        	event.getChannel().sendMessage(abc[new Random().nextInt(abc.length)]).queue();
        }
        /*if(arg1[0].contains("re")) {
        	EmbedBuilder ya = new EmbedBuilder();
        	ya.setTitle("Get your potato role here to access the full server:");
        	ya.setDescription("\n"+"\n"+"CLICK ON THE POTATO EMOJI");
        	event.getChannel().sendMessage(ya.build()).queue();
        }*/


    }
}
