package ru.unlimit.chatik.ui;

public class Message {

	private long timestamp;
	private String text;
	
	public Message(long timestamp, String text) {
		this.timestamp = timestamp;
		this.text = text;
	}
}
