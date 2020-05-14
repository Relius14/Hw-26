package commands;

import net.dv8tion.jda.api.entities.Message;

import java.io.FileWriter;
import java.io.IOException;

import static listener.BotListener.data;
import static listener.BotListener.gson;
import static util.MessageHandler.send;

public class StoreCommand extends Command {
	@Override
	public void execute(Message msg) {
		String[] s = msg.getContentRaw().split(" ", 3);
		if(s.length<3) {
			send(msg.getChannel(), "Prea putine argumente.", null, null);
		}else {
			data.put(s[1], s[2]);
			try {
				FileWriter FW = new FileWriter("D:\\data.json");
				gson.toJson(data, FW);
				FW.close();
				send(msg.getChannel(), "Stored.", null, null);
			}catch(IOException e) {
				e.printStackTrace();
				send(msg.getChannel(), "Eroare.", null, null);
			}
		}
	}
}
