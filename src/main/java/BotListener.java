import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import static commands.Command.*;
public class BotListener extends ListenerAdapter {

	String prefix = "!";

	@Override
	public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
		Message msg = event.getMessage();
		if(msg.getContentRaw().startsWith(prefix)) {
			String commandName = msg.getContentRaw().substring(prefix.length()).split(" ", 2)[0];
			if(commands.containsKey(commandName)) {
				commands.get(commandName).execute(msg);
			}
			else {
				if (aliases.containsKey(commandName)) {
					aliases.get(commandName).execute(msg);
				}
				//TODO: Add case for when the command is not found
			}
		}
		if(msg.getContentRaw().equalsIgnoreCase("hello")) {
			if(!event.getMember().getUser().isBot()) {
				event.getChannel().sendMessage("hello" + event.getMember().getUser().getName()).queue();
			}
		}
	}
}
