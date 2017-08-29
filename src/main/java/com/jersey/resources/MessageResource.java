package com.jersey.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.jersey.model.Message;
import com.jersey.resources.bean.MessageFilterBean;
import com.jersey.service.MessageService;

@Path("/messages")
public class MessageResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean mfb)	
	{
		if(mfb.getYear()>0)
			return new MessageService().getAllMessagesForYear(mfb.getYear());
		else if(mfb.getStart()>=0 && mfb.getSize()>0)
			return new MessageService().getAllMessagesPaginated(mfb.getStart(), mfb.getSize());
		else
			return new MessageService().getAllMessages();
	}
	
	@GET
	//@Produces(value={MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})  for one method send both response type
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean mfb)	
	{
		if(mfb.getYear()>0)
			return new MessageService().getAllMessagesForYear(mfb.getYear());
		else if(mfb.getStart()>=0 && mfb.getSize()>0)
			return new MessageService().getAllMessagesPaginated(mfb.getStart(), mfb.getSize());
		else
			return new MessageService().getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") int messageId,@Context UriInfo uriInfo)
	{
		Message message= new MessageService().getMessageById(messageId);	
				
		message.addLink(getUriForSelf(message, uriInfo),"self");
		message.addLink(getUriForComments(message, uriInfo),"comments");
		message.addLink(getUriForProfile(message, uriInfo),"profile");

		return message;
	}

	private String getUriForComments(Message message, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder()
			.path(MessageResource.class)
			.path(MessageResource.class,"getCommentResource")
			.path(CommentResource.class)
			.resolveTemplate("messageId", message.getId())
			.build()
			.toString();
		return uri;
	}
	
	private String getUriForProfile(Message message, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder()
			.path(ProfileResource.class)
			.path(message.getAuthor())
			.build()
			.toString();
		return uri;
	}
	
	private String getUriForSelf(Message message, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder()
			.path(MessageResource.class)
			.path(String.valueOf(message.getId()))
			.build()
			.toString();
		return uri;
	}
	
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMethod(Message msg,@Context UriInfo uriInfo)
	{
		Message message=new MessageService().addMessage(msg);
		
		URI uri=uriInfo.getAbsolutePathBuilder()
				.path(String.valueOf(msg.getId()))
				.build();
		
		return Response.created(uri)
			.entity(message)
			.build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMethod(@PathParam("messageId") int messageId,Message msg)
	{
		msg.setId(messageId);
		return new MessageService().updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") int messageId)
	{
		new MessageService().removeMessage(messageId);
	}
	
	@Path("{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
