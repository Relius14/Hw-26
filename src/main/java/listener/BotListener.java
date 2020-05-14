package listener;

import com.google.gson.Gson;
import commands.Command;
import commands.DeleteCommand;
import commands.GetCommand;
import commands.HelloCommand;
import commands.PingCommand;
import commands.StoreCommand;
import commands.WeekCommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class BotListener extends ListenerAdapter {

	public static Gson gson = new Gson();
	public static Map<String, String> data;
	public final Map<String, Command> commands;
	public final Map<String, Command> aliases;
	String prefix = "!";


	public BotListener() {
		commands = new HashMap<>();
		aliases = new HashMap<>();

		//TODO: automate command registering
		commands.put("ping", new PingCommand());
		commands.put("week", new WeekCommand());
		commands.put("hi", new HelloCommand());
		commands.put("hello", new HelloCommand());
		commands.put("store", new StoreCommand());
		commands.put("get", new GetCommand());
		commands.put("delete", new DeleteCommand());
	}

	@Override
	public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
		Message msg = event.getMessage();
		if(msg.getContentRaw().startsWith(prefix)) {
			String commandName = msg.getContentRaw().substring(prefix.length()).split(" ", 2)[0];
			if(commands.containsKey(commandName)) {
				commands.get(commandName).execute(msg);
			}else {
				if(aliases.containsKey(commandName)) {
					aliases.get(commandName).execute(msg);
				}
				//TODO: Add case for when the command is not found
			}
		}
	}
}
