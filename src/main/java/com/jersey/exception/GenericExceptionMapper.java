package com.jersey.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.jersey.model.*;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable de) {
		
		ErrorMessage me=new ErrorMessage("Internal Server Error...!!",500,"www.sanjaybankar.co.in");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(me)
				.build();
	}

}
