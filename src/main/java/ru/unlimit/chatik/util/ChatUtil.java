package ru.unlimit.chatik.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ru.unlimit.chatik.ui.Message;

public class ChatUtil {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	public static String getChat(List<Message> messages) {
		StringBuilder result = new StringBuilder();
		
		for(Message m: messages){
			result.append(sdf.format(new Date(m.getTimestamp())));
			result.append(": ");
			result.append(m.getText());
			result.append("<br>");
		}
		
		return result.toString();
	}
}
