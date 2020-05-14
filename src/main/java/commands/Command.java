package commands;

import net.dv8tion.jda.api.entities.Message;

//keep this as abstract class, in the future the base class might contain fields
public abstract class Command {

	public abstract void execute(Message msg);

}
