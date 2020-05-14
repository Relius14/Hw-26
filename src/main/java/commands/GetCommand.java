package commands;

import net.dv8tion.jda.api.entities.Message;

import static listener.BotListener.data;
import static util.MessageHandler.send;

public class GetCommand extends Command {
	@Override
	public void execute(Message msg) {
		String[] s = msg.getContentRaw().split(" ", 2);
		if(s.length<2) {
			send(msg.getChannel(), "Prea putine argumente.", null, null);
		}else {
			String val = data.get(s[1]);
			if(val == null) {
				send(msg.getChannel(), "Cheie inexistentă.", null, null);
			}else {
				send(msg.getChannel(), val, null, null);
			}
		}
	}
}
