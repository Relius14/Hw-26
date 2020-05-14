import listener.BotListener;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static listener.BotListener.data;
import static listener.BotListener.gson;

public class Main {
	public static void main(String[] args) throws LoginException, FileNotFoundException {
		if(args.length != 1) {
			System.out.println("Introduceți token-ul de autentificare!");
			return;
		}

		//System.out.println(args[0]);
		JDABuilder.createDefault(args[0]).addEventListeners(new BotListener()).build();

		FileReader FR = new FileReader("D:\\data.json");
		data = gson.fromJson(FR, HashMap.class);
		try {
			FR.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(data == null) {
			data = new HashMap<>();
		}
	}
}
