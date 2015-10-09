package ru.unlimit.chatik.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import ru.unlimit.chatik.ui.Message;

/**
 * Session Bean implementation class ChatBoxBean
 */
@Stateful
@LocalBean
public class ChatBoxBean {

	List<Message> messages;
	
    public ChatBoxBean() {
        messages = new ArrayList<>();
    }
    public void addMessage(Message msg){
    	messages.add(msg);
    }

}
