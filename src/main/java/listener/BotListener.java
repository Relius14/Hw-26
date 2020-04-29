package listener;

import commands.Command;
import commands.PingCommand;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class BotListener extends ListenerAdapter {

	String prefix = "!";
	public final Map<String, Command> commands;
	public final Map<String, Command> aliases;

	public BotListener() {
		commands = new HashMap<>();
		aliases = new HashMap<>();

		//TODO: automate command registering
		commands.put("ping", new PingCommand());
		//commands.put("ping", new PingCommand());
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