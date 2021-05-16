import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import java.util.List;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Bot1 {

    public static JDA jda;
    public static String prefix = "$";
    public static String prefix1 = "give";
    
    public static void main(String[] args) throws LoginException {
        List<GatewayIntent> gatewayIntents = new ArrayList<>();
        gatewayIntents.add(GatewayIntent.GUILD_MEMBERS);
    
        
        jda = new JDABuilder(AccountType.BOT).setToken("NzY5Mzc0MDE2MDY1NTAzMjcy.X5OFYw.zIeJZ7iev9rqZUvWbAciWUW14y0").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("$info for info about me"));
        
        
        
        jda.addEventListener(new info());
        jda.addEventListener(new Delete());
        jda.addEventListener(new responses());
        jda.addEventListener(new WelcomeDM());
        jda.addEventListener(new Bankick());
        jda.addEventListener(new reactionrole());
        jda.addEventListener(new automod1());
        jda.addEventListener(new EmbedMaker());
        jda.addEventListener(new DataBase1());
    }
        
}
