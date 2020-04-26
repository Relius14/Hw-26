import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
	public static void main(String[] args) throws LoginException {
		if(args.length != 1) {
			System.out.println("Introduceți token-ul de autentificare!");
			return;
		}

		System.out.println(args[0]);
		JDABuilder.createDefault(args[0]).addEventListeners(new BotListener()).build();
	}


}
