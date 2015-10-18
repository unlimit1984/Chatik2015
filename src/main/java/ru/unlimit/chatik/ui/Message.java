package ru.unlimit.chatik.ui;

public class Message {

	private final long timestamp;
	private final String text;
	
	public long getTimestamp() {return timestamp;}
	public String getText() {return text;}
	
	public Message(long timestamp, String text) {
		this.timestamp = timestamp;
		this.text = text;
	}
}
