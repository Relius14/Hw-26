package commands;

import net.dv8tion.jda.api.entities.Message;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.IsoFields;

import static util.MessageHandler.send;

public class WeekCommand extends Command {
	public static final WeekCommand INSTANCE = new WeekCommand();

	public void execute(Message msg) {
		ZoneId zoneId = ZoneId.of("Europe/Bucharest");
		ZonedDateTime now = ZonedDateTime.now(zoneId);
		int week = now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		send(msg.getChannel(), "Now, at " + now + ", the current week of the year is: " + week, null, null);
	}
}
