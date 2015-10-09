package ru.unlimit.chatik.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.unlimit.chatik.beans.ChatBoxBean;
import ru.unlimit.chatik.ui.Message;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	ChatBoxBean chat;
	
    public ChatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("command") != null){
			switch(request.getParameter("command")){
				case "add":
					String text = request.getParameter("message");
					chat.addMessage(new Message(System.currentTimeMillis(),text));
					break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
