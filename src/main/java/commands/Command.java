package commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
    public static final Map<String,Command> commands = new HashMap<String, Command>();
    public static final Map<String,Command> aliases = new HashMap<String, Command>();
    Command(String name) {
        commands.put(name,this);
    }
    public abstract void execute(Message msg);
    public Command alias(String name) {
        aliases.put(name, this);
        return this;
    }

}
