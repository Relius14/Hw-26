package commands;

import net.dv8tion.jda.api.entities.Message;

import java.util.HashMap;
import java.util.Map;

//keep this as abstract class, in the future the base class might contain fields
public abstract class Command {

	public abstract void execute(Message msg);

}
