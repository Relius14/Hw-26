package commands;

import net.dv8tion.jda.api.entities.Message;

import static util.MessageHandler.send;

public class PingCommand extends Command {

	@Override
	public void execute(Message msg) {
		send(msg.getChannel(), "Pong!", null, null);
	}
}
