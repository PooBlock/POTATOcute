
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.concurrent.TimeUnit;

 public class database1 extends ListenerAdapter {
	 public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		 String[] arg1 = event.getMessage().getContentRaw().split(" ");
		 String[] arg2 = event.getMessage().getContentRaw().split(":");
		 String string = event.getMessage().getContentRaw();
		 
		Connection connection=null;
		Statement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		
		String ipadress = "192.168.79.1";	
		final long Botrole = 771205181558751262L;
		final Long serverid = 769767404603441184L;
			//CONNECTION TO DATABASE
			
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://Localhost:5432/POTATOserver","postgres","PassWord");
		         if(connection!=null) {
		         }else {
					System.out.println("not connected"); 
				}
				}catch(Exception e) {
				System.out.println("error");
				}
	
			
			
			
			
			if(event.getChannel().toString().contains("register-your-bot"))	{
		if((arg2[0].toString().length()==18)&&(arg2[1].toString().length()==18)) {
				
					String firstarg = arg2[0].toString();
					String secarg = arg2[1].toString();
					String thirdarg = arg2[2].toString();
					
				try {
				
				
            System.out.println("updating1");
            
            stmt = connection.createStatement();
            
            stmt1 = connection.prepareStatement("select * from user_info");
			rs = stmt1.executeQuery();
			rs.next();
            System.out.println("updating2");
           
            //add user id to database if not already in it
			if(rs.getString("id").toString().contains(firstarg)) {
				System.out.println("user already in database.");
			}else {
            	stmt.executeUpdate("insert into user_info (id) values ("+firstarg+")");
            	stmt.executeUpdate("insert into server_user (server_id, user_id) values ("+serverid+", "+firstarg+")");
            	System.out.println("inserting users id.");
            }
                
            System.out.println("updating3");
			
			//add info to database
				stmt.executeUpdate("insert into bot_info (id_userinfo, bot_id, bot_name) values ("+firstarg+", "+secarg+", '"+thirdarg+"')");
				System.out.println("updating4");
				
				//give role to bot and give role to member
				event.getGuild().addRoleToMember(secarg, event.getJDA().getRoleById(Botrole)).queue();
				event.getGuild().addRoleToMember(firstarg, event.getJDA().getRoleById(Botrole)).queue();
				
				
				event.getChannel().sendMessage("**Hello "+event.getMember().getAsMention()+", your bot has been registered!**" 
				+ "_ _ \n _ _ \n**Hey there, paste your id, the bots id, and the bots name as such: \n"+"userID:botID:botNAME \n"+"\nEXAMPLE: 546412311783669770:772979861479751700:🥔MOD**").queue();
				
				
			
				
			
				
				
	              }catch(Exception e) {
					System.out.println("e");
					}
				
				
				}else if(string.equals("You are not using the right format. READ the example carefully and try again.")||string.contains("Hey there, paste your id, the bots id, and the bots name as such:")) {
					
				}
				else {
					event.getChannel().sendMessage("You are not using the right format. READ the example carefully and try again.").queue();
				}
			
	 
				
				
				
				
				
			
			}
	 
				
				}
	 }
 
 
	      
 
			
	 