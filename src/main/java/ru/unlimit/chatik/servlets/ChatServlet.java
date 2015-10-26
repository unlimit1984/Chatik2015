package ru.unlimit.chatik.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.unlimit.chatik.beans.ChatBoxBean;
import ru.unlimit.chatik.ui.Message;
import ru.unlimit.chatik.util.ChatUtil;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
           
	final static List<Message> messages = new ArrayList<>();
	final static int MAX_MESSAGE_COUNT = 50;
	final static Object sync = new Object();
	@Override
	public void init() throws ServletException {
		super.init();
		messages.add(new Message(System.currentTimeMillis(), "Добро пожаловать в чат!"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("command") != null){
			switch(request.getParameter("command")){
				case "add":
					synchronized (sync) {
						String text = request.getParameter("message");
						messages.add(new Message(System.currentTimeMillis(),text));
						if(messages.size()>MAX_MESSAGE_COUNT){
							messages.remove(0);
						}
					}
					break;
				case "getChat":
					String chatText;
					synchronized (sync) {
						chatText = ChatUtil.getChat(messages);
					}
					PrintWriter out=response.getWriter();
					out.write(chatText);
					out.close();
					break;
			}
		}
	}
}
