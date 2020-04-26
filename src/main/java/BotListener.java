import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class BotListener extends ListenerAdapter {

	String prefix = "!";

	@Override
	public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
		Message msg = event.getMessage();
		if(msg.getContentRaw().startsWith(prefix)) {
			//TODO: implement command execution
		}
	}
}
