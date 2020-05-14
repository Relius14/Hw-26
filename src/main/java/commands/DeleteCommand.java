package commands;

import net.dv8tion.jda.api.entities.Message;

import java.io.FileWriter;
import java.io.IOException;

import static listener.BotListener.data;
import static listener.BotListener.gson;
import static util.MessageHandler.send;

public class DeleteCommand extends Command {
	@Override
	public void execute(Message msg) {
		String[] s = msg.getContentRaw().split(" ", 2);
		if(s.length<2) {
			send(msg.getChannel(), "Prea putine argumente.", null, null);
		}else {
			if(data.remove(s[1]) == null) {
				send(msg.getChannel(), "Cheie inexistentă.", null, null);
			}else {
				try {
					FileWriter FW = new FileWriter("D:\\data.json");
					gson.toJson(data, FW);
					FW.close();
					send(msg.getChannel(), "Sters.", null, null);
				}catch(IOException e) {
					e.printStackTrace();
					send(msg.getChannel(), "Eroare.", null, null);
				}
			}
		}
	}
}
