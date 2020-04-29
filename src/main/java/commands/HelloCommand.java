package commands;

import net.dv8tion.jda.api.entities.Message;

import static util.MessageHandler.*;

public class HelloCommand extends Command{

	@Override
	public void execute(Message msg) { send(msg.getChannel(), "Hello!", null, null); }
}
