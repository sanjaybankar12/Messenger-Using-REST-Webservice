package com.jersey.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.jersey.model.Comment;
import com.jersey.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	@GET
	public List<Comment> getComments(@PathParam("messageId") int messageId)
	{
		return new CommentService().getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
		return new CommentService().getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") int messageId,Comment comment)
	{
		return new CommentService().addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId,Comment comment)
	{
		comment.setId(commentId);
		return new CommentService().updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") int messageId,@PathParam("commentId") int commentId)
	{
		return new CommentService().deleteComment(messageId, commentId);
	}
	
}
