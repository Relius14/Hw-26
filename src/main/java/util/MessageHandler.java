package util;


import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.function.Consumer;

public class MessageHandler {

	public static void send(MessageChannel channel, String message, Consumer<? super Message> onSuccess, Consumer<? super Throwable> onFail) {
		channel.sendMessage(message).queue(onSuccess, onFail);
	}
}
