package com.jersey.service;

import java.util.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.jersey.exception.*;
import com.jersey.database.DatabaseClass;
import com.jersey.model.Message;

public class MessageService {

	public Map<Integer,Message> messages=DatabaseClass.getMessages();
	
	public MessageService()
	{
		Message m1=new Message(1,"Sanjay is java developer..!!",new Date(),"Sanjay");
		Message m2=new Message(2,"sanju is rest developer..!!",new Date(),"sanju");
		
		messages.put(1,m1);
		messages.put(2,m2);
	}
	
	public List<Message> getAllMessages()
	{
		List<Message> list=new ArrayList<>(messages.values());		
		
		return list;
	}
	
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> list=new ArrayList<>();		
		
		Calendar cal=Calendar.getInstance();
		for(Message msg:messages.values())
		{
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				list.add(msg);
			}
		}
		
		return list;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		List<Message> list=new ArrayList<>(messages.values());		
		
		if((start+size)>messages.size())
			return null;
		
		return list.subList(start, (start+size));
	}
		
	public Message getMessageById(int id)
	{
		Message message=messages.get(id);
		if(message==null)
		{
			throw new DataNotFoundException("Content with id "+id+" Not Found...!!");
		}
		return message;
	}
	
	public Message addMessage(Message msg)
	{
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		
		return msg;
	}
	
	public Message updateMessage(Message msg)
	{
		if(msg.getId()<0)
			return null;
		messages.put(msg.getId(), msg);
		
		return msg;
	}
	
	public void removeMessage(int messageId)
	{
		messages.remove(messageId);
	}
	
}
