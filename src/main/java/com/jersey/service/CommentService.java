package com.jersey.service;

import java.util.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jersey.database.DatabaseClass;
import com.jersey.model.*;

public class CommentService {

	public Map<Integer,Message> messages=DatabaseClass.getMessages();	
	
	public List<Comment> getAllComments(int messageId)
	{
		Map<Integer,Comment> comments=messages.get(messageId).getComments();
		
		List<Comment> list=new ArrayList<>(comments.values());
		return list;
	}
	
	public Comment getComment(int messageId,int commentId)
	{
		ErrorMessage errMsg=new ErrorMessage("Contetn Not Found..!!",404,"www.sanjaybankar.co.in");
		Response response=Response.status(Status.NOT_FOUND)
			.entity(errMsg)
			.build();
		
		Message message=messages.get(messageId);
		if(message==null)
			throw new WebApplicationException(response);
		Map<Integer,Comment> comments=message.getComments();
		
		Comment comment=comments.get(commentId);
		if(comment==null)
			throw new NotFoundException(response);
		
		return comment;
	}
	
	public Comment addComment(int messageId,Comment comment)
	{
		Map<Integer,Comment> comments=messages.get(messageId).getComments();
		
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	public Comment updateComment(int messageId,Comment comment)
	{
		Map<Integer,Comment> comments=messages.get(messageId).getComments();
		
		if(comment.getId()<0)
			return null;
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	public Comment deleteComment(int messageId,int commentId)
	{
		Map<Integer,Comment> comments=messages.get(messageId).getComments();
		
		return comments.remove(commentId);
	}
}
